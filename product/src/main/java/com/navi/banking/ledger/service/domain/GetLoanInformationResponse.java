package com.navi.banking.ledger.service.domain;

public class GetLoanInformationResponse
{
    private String bank;
    private String user;
    private int totalAmount;
    private int totalAmountPaid;
    private int totalRemainingPayments;
    private int totalMonthlyInstallmentsRemaining;
    private int totalInstallments;

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

    public int getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmountPaid()
    {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(int totalAmountPaid)
    {
        this.totalAmountPaid = totalAmountPaid;
    }

    public int getTotalRemainingPayments()
    {
        return totalRemainingPayments;
    }

    public void setTotalRemainingPayments(int totalRemainingPayments)
    {
        this.totalRemainingPayments = totalRemainingPayments;
    }

    public int getTotalMonthlyInstallmentsRemaining()
    {
        return totalMonthlyInstallmentsRemaining;
    }

    public void setTotalMonthlyInstallmentsRemaining(int totalMonthlyInstallmentsRemaining)
    {
        this.totalMonthlyInstallmentsRemaining = totalMonthlyInstallmentsRemaining;
    }

    public int getTotalInstallments()
    {
        return totalInstallments;
    }

    public void setTotalInstallments(int totalInstallments)
    {
        this.totalInstallments = totalInstallments;
    }
}
