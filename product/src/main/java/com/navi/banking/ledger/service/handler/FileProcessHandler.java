package com.navi.banking.ledger.service.handler;

import com.navi.banking.ledger.service.service.BankLedgerService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class FileProcessHandler
{
    private final BankLedgerService service;

    public FileProcessHandler(BankLedgerService service)
    {
        this.service = service;
    }

    public void handle(Resource resource)
    {
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(resource.getInputStream())))
        {
            String command = reader.readLine();
            while(!StringUtils.isBlank(command))
            {
                service.process(command);
                command = reader.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
