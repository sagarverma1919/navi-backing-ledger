package com.navi.banking.ledger.service.domain;

public class GetLoanInformationRequest
{
    private String bank;
    private String user;
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

    public int getTotalInstallments()
    {
        return totalInstallments;
    }

    public void setTotalInstallments(int totalInstallments)
    {
        this.totalInstallments = totalInstallments;
    }
}
