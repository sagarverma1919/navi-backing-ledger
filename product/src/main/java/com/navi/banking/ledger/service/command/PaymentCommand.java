package com.navi.banking.ledger.service.command;

import com.navi.banking.ledger.domain.LumpSumTransaction;
import com.navi.banking.ledger.service.dao.DAOLayer;
import com.navi.banking.ledger.service.domain.GetLoanInformationRequest;
import com.navi.banking.ledger.service.domain.UpdateTransactionRequest;
import com.navi.banking.ledger.service.repository.BankRepository;
import com.navi.banking.ledger.service.utils.AssertionUtils;

import org.springframework.stereotype.Component;

@Component
public class PaymentCommand extends AbstractCommand
{
    private final BankRepository repository;
    private final BalanceCommand balanceCommand;

    public PaymentCommand(BankRepository repository, BalanceCommand balanceCommand)
    {
        super(5);
        this.repository = repository;
        this.balanceCommand = balanceCommand;
    }

    @Override
    protected String execute(String[] params) throws Exception
    {
        UpdateTransactionRequest request = new UpdateTransactionRequest();

        request.setBank(params[1]);
        request.setUser(params[2]);

        LumpSumTransaction transaction = new LumpSumTransaction(Integer.parseInt(params[4]));
        transaction.setLumpSumAmount(Integer.parseInt(params[3]));
        request.setTransaction(transaction);
        request.setTransactionNumber(Integer.parseInt(params[4]));

        handle(request);
        return null;
    }

    private void handle(UpdateTransactionRequest request) throws Exception
    {
        DAOLayer registry = repository.getOrCreateRegistry(request.getBank());

        GetLoanInformationRequest loanInformationRequest = new GetLoanInformationRequest();

        loanInformationRequest.setUser(request.getUser());
        loanInformationRequest.setBank(request.getBank());
        loanInformationRequest.setTotalInstallments(request.getTransactionNumber());

        AssertionUtils.validate(balanceCommand.getLoanInformation(loanInformationRequest), request);
        registry.update(request);
    }
}