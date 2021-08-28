package com.navi.banking.ledger.service.dao;

import static com.navi.banking.ledger.service.utils.MapperUtils.loanRequestMapper;

import com.navi.banking.ledger.domain.Loan;
import com.navi.banking.ledger.domain.Transaction;
import com.navi.banking.ledger.service.domain.CreateLoanRequest;
import com.navi.banking.ledger.service.domain.UpdateTransactionRequest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BankLedger implements DAOLayer
{
    private final Map<String, Loan> ledger;

    public BankLedger()
    {
        this.ledger = new HashMap<>();
    }

    @Override
    public void create(CreateLoanRequest request)
    {
        Loan loan = loanRequestMapper(request);
        ledger.put(request.getUser(), loan);
    }

    @Override
    public void update(UpdateTransactionRequest request)
    {
        Loan loan = ledger.get(request.getUser());
        LinkedList<Transaction> transactions = loan.getTransactions();

        if (transactions.size() < request.getTransactionNumber())
        {
            transactions.add(transactions.size(), request.getTransaction());
        }
        else
        {
            transactions.add(request.getTransactionNumber(), request.getTransaction());
        }
    }

    @Override
    public Loan lookup(String request)
    {
        return ledger.get(request);
    }
}
