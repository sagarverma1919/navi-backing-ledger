package com.navi.banking.ledger.service.service;

import com.navi.banking.ledger.service.command.BalanceCommand;
import com.navi.banking.ledger.service.command.LoanCommand;
import com.navi.banking.ledger.service.command.PaymentCommand;

import org.springframework.stereotype.Component;

@Component
public class BankLedgerService
{
    private static final String SEPARATOR = "\\s+";

    private final BalanceCommand balanceCommand;
    private final LoanCommand loanCommand;
    private final PaymentCommand paymentCommand;


    public BankLedgerService(BalanceCommand balanceCommand,
                             LoanCommand loanCommand,
                             PaymentCommand paymentCommand)
    {
        this.balanceCommand = balanceCommand;
        this.loanCommand = loanCommand;
        this.paymentCommand = paymentCommand;
    }


    public void process(String command)
    {
        String[] params = command.split(SEPARATOR);
        switch (params[0])
        {
            case "BALANCE":
                balanceCommand.process(params);
                break;
            case "LOAN":
                loanCommand.process(params);
                break;
            case "PAYMENT":
                paymentCommand.process(params);
                break;
        }
    }
}
