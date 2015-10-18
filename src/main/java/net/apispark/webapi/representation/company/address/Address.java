package net.apispark.webapi.representation.company.address;

import java.io.Serializable;

public class Address implements Serializable {

    private String street;

    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    private String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    private String city;

    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
