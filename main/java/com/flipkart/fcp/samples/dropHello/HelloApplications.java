package com.flipkart.fcp.samples.dropHello;

import com.flipkart.fcp.samples.dropHello.api.*;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;


public class HelloApplications extends Application <HelloConf>
{
    public static void main (String[] args) throws Exception
    {
        new HelloApplications().run(args);
    }

    @Override
    public  String getName() { return "Hello-World-App";}

    @Override
    public void initialize (io.dropwizard.setup.Bootstrap <HelloConf> confBootstrap)
    {

    }

    @Override
    public void run (HelloConf conf, Environment env) {
        {
            final HelloApi resource = new HelloApi(conf.getTemplate(), conf.getDefaultName() );

            //HelloHealthCheck healthCheck = new HelloHealthCheck(conf.getTemplate());
            HelloHealthCheck healthCheck = new HelloHealthCheck(conf.getTemplate());
            env.healthChecks().register("template",healthCheck);

            env.jersey().register(resource);
            env.jersey().register(new UserApi());
        }
    }
}

