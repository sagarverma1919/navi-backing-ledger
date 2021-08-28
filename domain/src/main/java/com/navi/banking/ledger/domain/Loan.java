package com.navi.banking.ledger.domain;

import java.util.LinkedList;

/**
 * The type Loan.
 */
public class Loan
{
    private int principle;
    private int tenure;
    private double rateOfInterest;
    private int totalAmountToBePaid;
    private int installmentsAmount;
    private int totalInstallments;
    private int totalInstallmentsPaid;
    private int totalAmountPaid;
    private final LinkedList<Transaction> transactions = new LinkedList<>();

    /**
     * Gets principle.
     *
     * @return the principle
     */
    public int getPrinciple()
    {
        return principle;
    }

    /**
     * Sets principle.
     *
     * @param principle the principle
     */
    public void setPrinciple(int principle)
    {
        this.principle = principle;
    }

    /**
     * Gets tenure.
     *
     * @return the tenure
     */
    public int getTenure()
    {
        return tenure;
    }

    /**
     * Sets tenure.
     *
     * @param tenure the tenure
     */
    public void setTenure(int tenure)
    {
        this.tenure = tenure;
    }

    /**
     * Gets rate of interest.
     *
     * @return the rate of interest
     */
    public double getRateOfInterest()
    {
        return rateOfInterest;
    }

    /**
     * Sets rate of interest.
     *
     * @param rateOfInterest the rate of interest
     */
    public void setRateOfInterest(double rateOfInterest)
    {
        this.rateOfInterest = rateOfInterest;
    }

    /**
     * Gets total amount to be paid.
     *
     * @return the total amount to be paid
     */
    public int getTotalAmountToBePaid()
    {
        return totalAmountToBePaid;
    }

    /**
     * Sets total amount to be paid.
     *
     * @param totalAmountToBePaid the total amount to be paid
     */
    public void setTotalAmountToBePaid(int totalAmountToBePaid)
    {
        this.totalAmountToBePaid = totalAmountToBePaid;
    }

    /**
     * Gets installments amount.
     *
     * @return the installments amount
     */
    public int getInstallmentsAmount()
    {
        return installmentsAmount;
    }

    /**
     * Sets installments amount.
     *
     * @param installmentsAmount the installments amount
     */
    public void setInstallmentsAmount(int installmentsAmount)
    {
        this.installmentsAmount = installmentsAmount;
    }

    /**
     * Gets total amount paid.
     *
     * @return the total amount paid
     */
    public int getTotalAmountPaid()
    {
        return totalAmountPaid;
    }

    /**
     * Sets total amount paid.
     *
     * @param totalAmountPaid the total amount paid
     */
    public void setTotalAmountPaid(int totalAmountPaid)
    {
        this.totalAmountPaid = totalAmountPaid;
    }

    /**
     * Gets total installments.
     *
     * @return the total installments
     */
    public int getTotalInstallments()
    {
        return totalInstallments;
    }

    /**
     * Sets total installments.
     *
     * @param totalInstallments the total installments
     */
    public void setTotalInstallments(int totalInstallments)
    {
        this.totalInstallments = totalInstallments;
    }

    /**
     * Gets total installments paid.
     *
     * @return the total installments paid
     */
    public int getTotalInstallmentsPaid()
    {
        return totalInstallmentsPaid;
    }

    /**
     * Sets total installments paid.
     *
     * @param totalInstallmentsPaid the total installments paid
     */
    public void setTotalInstallmentsPaid(int totalInstallmentsPaid)
    {
        this.totalInstallmentsPaid = totalInstallmentsPaid;
    }

    /**
     * Gets transactions.
     *
     * @return the transactions
     */
    public LinkedList<Transaction> getTransactions()
    {
        return transactions;
    }
}
