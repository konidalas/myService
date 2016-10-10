package com.flipkart.fcp.samples.dropHello;

import com.codahale.metrics.health.HealthCheck;



import com.codahale.metrics.health.HealthCheck;

public class HelloHealthCheck extends HealthCheck
{
    private String template;

    public  HelloHealthCheck (String template)
    {
        this.template=template;
    }

    @Override
    protected Result check () throws Exception
    {
        final  String sayHello = String.format(template, "TEST");
        if (!sayHello.contains("TEST"))
        {
            return Result.unhealthy("template does not include a name");
        }
        return Result.healthy();
    }
}
