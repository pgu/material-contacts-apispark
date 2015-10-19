package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.apispark.webapi.core.validation.ValidationErrors;
import net.apispark.webapi.representation.enums.Gender;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String avatar;
    private Date birthday;
    private Boolean active;
    private Integer rank;
    private String companyId;

    public Contact(){}

    public Contact(String id, String firstName, String lastName, String avatar) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty(required = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty(required = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }


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
