package com.flipkart.fcp.samples.dropHello.api;

import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.Produces;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path ("/HelloApi")
@Produces (MediaType.APPLICATION_JSON)

public  class HelloApi {
    private String template ="Init";
    private String defaultName ="init";
    private AtomicLong counter;

    public HelloApi(String template, String defaultname) {

        this.template = template;
        this.defaultName = template;
        this.counter = new AtomicLong();

    }

    @GET
    @Timed
    public HelloRes HelloApi (@QueryParam("name") Optional <String> name)
    {
        final String value = String.format (template,name.or(defaultName));
        return new HelloRes(counter.incrementAndGet(),value);
    }
}


