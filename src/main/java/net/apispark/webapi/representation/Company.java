package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.apispark.webapi.core.validation.ValidationErrors;
import net.apispark.webapi.representation.company.address.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {

    private String id;
    private String name;
    private List<String> tags;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @JsonProperty(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getTags() {
        if (tags == null) {
            tags = new ArrayList<String>();
        }
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void validate() {
        ValidationErrors validationErrors = new ValidationErrors();
        if (name == null || name.isEmpty()) {
            validationErrors.addFieldError("name", "This field is required");
        }
        validationErrors.checkErrors("Company entity is not valid");
    }
}
