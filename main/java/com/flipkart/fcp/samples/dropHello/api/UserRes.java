package com.flipkart.fcp.samples.dropHello.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.fcp.samples.dropHello.model.User;

/**
 * Created by satheesh.konidala on 30/06/16.
 */
public class UserRes {
    private String emailId;
    private String firstName;
    private String lastName;
    private String address;
    private String pincode;

    public UserRes (String emailId, String firstName, String lastName, String address, String pincode)
    {
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.pincode = pincode;
    }

    public  UserRes (User user)
    {
        this.emailId = user.email_id;
        this.firstName = user.first_name;
        this.lastName = user.last_name;
        this.address = user.address;
        this.pincode = user.pincode;
    }

    @JsonProperty
    public String getEmail () { return emailId;}

    @JsonProperty
    public String getFirstName () { return firstName;}

    @JsonProperty
    public String getLastName () { return lastName;}

    @JsonProperty
    public String getAddress () { return address;}

    @JsonProperty
    public String getPincode () { return pincode;}

    @JsonProperty
    public String getFullName () { return firstName+lastName;}

}
