package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.apispark.webapi.core.validation.ValidationErrors;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {

    private String id;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String firstName;


    @JsonProperty(required = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    private String lastName;


    @JsonProperty(required = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    private String avatar;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private Date birthday;


    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    private Boolean active;

    
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    private Integer rank;

    
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }


    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void validate() {
        ValidationErrors validationErrors = new ValidationErrors();
        if (firstName == null || firstName.isEmpty()) {
            validationErrors.addFieldError("first_name", "This field is required");
        }
        if (lastName == null || lastName.isEmpty()) {
            validationErrors.addFieldError("last_name", "This field is required");
        }
        validationErrors.checkErrors("Contact entity is not valid");
    }
}
