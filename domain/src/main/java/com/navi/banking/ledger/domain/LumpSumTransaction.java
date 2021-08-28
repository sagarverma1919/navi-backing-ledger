package com.navi.banking.ledger.domain;

public class LumpSumTransaction extends Transaction
{
    private int lumpSumAmount;

    public LumpSumTransaction(int transactionNumber)
    {
        super(transactionNumber);
    }

    public int getLumpSumAmount()
    {
        return lumpSumAmount;
    }

    public void setLumpSumAmount(int lumpSumAmount)
    {
        this.lumpSumAmount = lumpSumAmount;
    }
}
