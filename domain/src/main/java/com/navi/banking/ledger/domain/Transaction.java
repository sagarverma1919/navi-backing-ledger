package com.navi.banking.ledger.domain;

public abstract class Transaction
{
    private final int transactionNumber;

    public Transaction(int transactionNumber)
    {
        this.transactionNumber = transactionNumber;
    }

    public int getTransactionNumber()
    {
        return transactionNumber;
    }
}
