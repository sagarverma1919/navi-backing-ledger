package com.navi.banking.ledger.service.utils;

import com.navi.banking.ledger.domain.Loan;
import com.navi.banking.ledger.service.domain.CreateLoanRequest;

public class MapperUtils
{


    public static Loan loanRequestMapper(CreateLoanRequest request)
    {
        Loan loan = new Loan();
        loan.setPrinciple(request.getPrinciple());
        loan.setTenure(request.getTenure());
        loan.setRateOfInterest(request.getRateOfInterest());

        loan.setTotalAmountToBePaid((int) Math.ceil(request.getPrinciple() *
                                                    request.getRateOfInterest() / 100 * request
                                                        .getTenure()
                                                    + request.getPrinciple()));

        loan.setTotalInstallments(request.getTenure() * 12);
        loan.setInstallmentsAmount((int) Math.ceil((double) loan.getTotalAmountToBePaid() /
                                                   (double) loan.getTotalInstallments()));

        return loan;
    }
}
