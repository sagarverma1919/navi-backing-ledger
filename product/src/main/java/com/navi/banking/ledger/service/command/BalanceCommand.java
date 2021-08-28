package com.navi.banking.ledger.service.command;

import com.navi.banking.ledger.domain.Loan;
import com.navi.banking.ledger.domain.LumpSumTransaction;
import com.navi.banking.ledger.domain.Transaction;
import com.navi.banking.ledger.service.dao.DAOLayer;
import com.navi.banking.ledger.service.domain.GetLoanInformationRequest;
import com.navi.banking.ledger.service.domain.GetLoanInformationResponse;
import com.navi.banking.ledger.service.repository.BankRepository;
import com.navi.banking.ledger.service.utils.AssertionUtils;

import org.springframework.stereotype.Component;

@Component
public class BalanceCommand extends AbstractCommand
{
    private final BankRepository repository;

    public BalanceCommand(BankRepository repository)
    {
        super(4);
        this.repository = repository;
    }

    @Override
    protected String execute(String[] requests) throws Exception
    {
        GetLoanInformationRequest request = new GetLoanInformationRequest();
        request.setBank(requests[1]);
        request.setUser(requests[2]);
        request.setTotalInstallments(Integer.parseInt(requests[3]));

        GetLoanInformationResponse response = getLoanInformation(request);

        return new StringBuilder().append(request.getBank())
            .append(" ").append(request.getUser())
            .append(" ").append(response.getTotalAmountPaid())
            .append(" ").append(response.getTotalMonthlyInstallmentsRemaining()).toString();
    }

    public GetLoanInformationResponse getLoanInformation(GetLoanInformationRequest request)
        throws Exception
    {
        DAOLayer registry = repository.getOrCreateRegistry(request.getBank());
        Loan loan = registry.lookup(request.getUser());

        AssertionUtils.validate(loan, request);
        GetLoanInformationResponse response = new GetLoanInformationResponse();
        response.setBank(request.getBank());
        response.setUser(request.getUser());

        int totalLumpSumAmountPaid = 0;
        for (Transaction transaction : loan.getTransactions())
        {
            if (transaction.getTransactionNumber() > request.getTotalInstallments())
            {
                break;
            }

            totalLumpSumAmountPaid += ((LumpSumTransaction) transaction).getLumpSumAmount();
        }

        int totalMonthlyInstallmentsPaid =
            request.getTotalInstallments() * loan.getInstallmentsAmount();

        response.setTotalAmountPaid(
            Math.min(totalLumpSumAmountPaid + totalMonthlyInstallmentsPaid,
                     loan.getTotalAmountToBePaid()));

        response.setTotalMonthlyInstallmentsRemaining(
            (int) Math.ceil((double) (loan.getTotalAmountToBePaid() - response.getTotalAmountPaid())
                            / (double) loan
                .getInstallmentsAmount()));

        response.setTotalRemainingPayments(
            loan.getTotalAmountToBePaid() - response.getTotalAmountPaid());

        response.setTotalInstallments(loan.getTotalInstallments());
        response.setTotalAmount(loan.getTotalAmountToBePaid());
        return response;
    }
}