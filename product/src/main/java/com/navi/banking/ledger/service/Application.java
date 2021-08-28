package com.navi.banking.ledger.service;

import com.navi.banking.ledger.service.handler.FileProcessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@SpringBootApplication
@PropertySource({"classpath:application.properties"})
public class Application implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private FileProcessHandler handler;

    @Autowired
    private ConfigurableApplicationContext context;

    @Value("file:${com.navi.bank.ledger.processing.file}")
    private Resource resource;

    @Override
    public void run(String... args) throws Exception
    {
        handler.handle(resource);
        System.exit(SpringApplication.exit(context));
    }
}
