package com.flipkart.fcp.samples.dropHello.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


public  class HelloRes
{
    private long id;

    @Length (max=5)
    private  String content;

    public HelloRes()
    {
    }

    public HelloRes(long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId ()
    {
        return id;
    }

    @JsonProperty
    public String getContent()
    {
        return content;
    }


}
