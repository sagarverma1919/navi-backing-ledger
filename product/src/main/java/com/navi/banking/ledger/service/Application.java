package com.navi.banking.ledger.service;

import com.navi.banking.ledger.service.handler.FileProcessHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.navi.banking.ledger.service")
public class Application
{
    private static final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

    public static void main(String[] args)
    {
        FileProcessHandler handler = context.getBean(FileProcessHandler.class);
        handler.handle(args[0]);
    }
}
