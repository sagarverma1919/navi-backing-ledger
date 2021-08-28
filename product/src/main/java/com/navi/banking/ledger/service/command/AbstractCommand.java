package com.navi.banking.ledger.service.command;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public abstract class AbstractCommand
{
    private final int params;
    private final Logger log;

    public AbstractCommand(int params)
    {
        this.params = params;
        this.log = Logger.getLogger(this.getClass().getSimpleName());
    }

    public void process(String[] params)
    {
        if (validate(params))
        {
            try

            {
                String response = this.execute(params);
                if (!StringUtils.isBlank(response))
                {
                    System.out.println(response);
                }
            }
            catch (Exception exception)
            {
                log.info(exception.getMessage());
            }
        }
    }

    protected abstract String execute(String[] params) throws Exception;

    private boolean validate(String[] request)
    {
        return request.length == params;
    }
}
