package com.navi.banking.ledger.service.command;

import com.navi.banking.ledger.service.dao.DAOLayer;
import com.navi.banking.ledger.service.domain.CreateLoanRequest;
import com.navi.banking.ledger.service.repository.BankRepository;
import com.navi.banking.ledger.service.utils.AssertionUtils;

import org.springframework.stereotype.Component;

@Component
public class LoanCommand extends AbstractCommand
{

    private final BankRepository repository;

    public LoanCommand(BankRepository repository)
    {
        super(6);
        this.repository = repository;
    }

    @Override
    protected String execute(String[] requests) throws Exception
    {

        CreateLoanRequest request = new CreateLoanRequest();

        request.setBank(requests[1]);
        request.setUser(requests[2]);
        request.setPrinciple(Integer.parseInt(requests[3]));
        request.setTenure(Integer.parseInt(requests[4]));
        request.setRateOfInterest(Double.parseDouble(requests[5]));

        handle(request);
        return null;
    }

    private void handle(CreateLoanRequest request) throws Exception
    {
        AssertionUtils.validate(request);

        DAOLayer registry = repository.getOrCreateRegistry(request.getBank());
        registry.create(request);
    }
}
