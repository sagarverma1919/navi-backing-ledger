package com.navi.banking.ledger.service.repository;

import com.navi.banking.ledger.service.dao.BankLedger;
import com.navi.banking.ledger.service.dao.DAOLayer;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BankRepository
{
    private final Map<String, DAOLayer> repository = new HashMap<>();

    public DAOLayer getOrCreateRegistry(String bank)
    {
        return repository.computeIfAbsent(bank, o -> new BankLedger());
    }
}
