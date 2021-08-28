package com.navi.banking.ledger.domain;

public class EMITransaction extends Transaction
{
    private int totalEMIs;
    private int emiAmount;

    public EMITransaction(int transactionNumber)
    {
        super(transactionNumber);
    }



    public int getTotalEMIs()
    {
        return totalEMIs;
    }

    public void setTotalEMIs(int totalEMIs)
    {
        this.totalEMIs = totalEMIs;
    }

    public int getEmiAmount()
    {
        return emiAmount;
    }

    public void setEmiAmount(int emiAmount)
    {
        this.emiAmount = emiAmount;
    }
}
