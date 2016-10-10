package com.flipkart.fcp.samples.dropHello;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloConf extends Configuration
{

@NotEmpty
private String templateName;

@NotEmpty
private String defaultName = "Satheesh Konidala";



@JsonProperty
public String getTemplate ()
{
	return templateName;
}
@JsonProperty
public void setTemplate (String tName1)
{
	templateName = tName1;
}

@JsonProperty
public String getDefaultName ()
{
return defaultName;
}

@JsonProperty
public void setDefaultName (String defName)
{
	defaultName = defName;
}

}
