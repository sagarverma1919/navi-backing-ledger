package com.navi.banking.ledger.service.domain;

public class CreateLoanRequest
{
    private String bank;
    private String user;
    private int principle;
    private int tenure;
    private double rateOfInterest;

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

    public int getPrinciple()
    {
        return principle;
    }

    public void setPrinciple(int principle)
    {
        this.principle = principle;
    }

    public int getTenure()
    {
        return tenure;
    }

    public void setTenure(int tenure)
    {
        this.tenure = tenure;
    }

    public double getRateOfInterest()
    {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest)
    {
        this.rateOfInterest = rateOfInterest;
    }

}
