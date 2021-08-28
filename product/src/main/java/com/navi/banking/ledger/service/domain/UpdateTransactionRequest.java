package com.navi.banking.ledger.service.domain;

import com.navi.banking.ledger.domain.Transaction;

public class UpdateTransactionRequest
{
    private String bank;
    private String user;
    private int transactionNumber;
    private Transaction transaction;

    public String getBank()
    {
        return bank;
    }

    public void setBank(String bank)
    {
        this.bank = bank;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public int getTransactionNumber()
    {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber)
    {
        this.transactionNumber = transactionNumber;
    }

    public Transaction getTransaction()
    {
        return transaction;
    }

    public void setTransaction(Transaction transaction)
    {
        this.transaction = transaction;
    }
}
