package com.navi.banking.ledger.service.handler;

import com.navi.banking.ledger.service.service.BankLedgerService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class FileProcessHandler
{
    @Autowired
    private BankLedgerService service;

    public void handle(String path)
    {
        Resource resource = new FileSystemResource(path);
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
