package com.navi.banking.ledger.service.dao;

import com.navi.banking.ledger.domain.Loan;
import com.navi.banking.ledger.service.domain.CreateLoanRequest;
import com.navi.banking.ledger.service.domain.GetLoanInformationRequest;
import com.navi.banking.ledger.service.domain.GetLoanInformationResponse;
import com.navi.banking.ledger.service.domain.UpdateTransactionRequest;


/**
 * The interface Dao layer.
 */
public interface DAOLayer
{
    /**
     * Create.
     *
     * @param request the request
     */
    void create(CreateLoanRequest request);

    /**
     * Update.
     *
     * @param request the request
     */
    void update(UpdateTransactionRequest request);

    /**
     * Lookup get loan information response.
     *
     * @param request the request
     * @return the get loan information response
     */
    Loan lookup(String request);
}
