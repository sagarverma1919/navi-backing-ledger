package com.navi.banking.ledger.service.utils;

import com.navi.banking.ledger.domain.Loan;
import com.navi.banking.ledger.domain.LumpSumTransaction;
import com.navi.banking.ledger.service.domain.CreateLoanRequest;
import com.navi.banking.ledger.service.domain.GetLoanInformationRequest;
import com.navi.banking.ledger.service.domain.GetLoanInformationResponse;
import com.navi.banking.ledger.service.domain.UpdateTransactionRequest;

public class AssertionUtils
{

    public static void validate(GetLoanInformationResponse response, UpdateTransactionRequest request)
        throws Exception
    {
        LumpSumTransaction transaction = (LumpSumTransaction) request.getTransaction();

        if (response.getTotalInstallments() <= request.getTransactionNumber())
        {
            throw new Exception("transaction number cannot be greater than than total emis");
        }

        if (response.getTotalAmountPaid() + transaction.getLumpSumAmount() > response
            .getTotalAmount())
        {
            throw new Exception("lump sum amount cannot be greater than total amount to be paid");
        }
    }

    public static void validate(CreateLoanRequest request) throws Exception
    {
        if (request.getTenure() < 0 || request.getRateOfInterest() < 0
            || request.getPrinciple() < 0)
        {
            throw new Exception("loan request is invalid");
        }
    }

    public static void validate(Loan loan, GetLoanInformationRequest request) throws Exception
    {
        if (loan == null)
        {
            throw new Exception("loan information not found");
        }

        if(loan.getTotalInstallments() < request.getTotalInstallments())
        {
            throw new Exception("invalid loan request");
        }
    }
}
