package com.rohan.development.contractdrivendevelopmentsample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Document(collection = PersonModel.PERSON_COLLECTION)
public class PersonModel {
    public static final String PERSON_COLLECTION = "customer";
    @NotBlank
    @Id
    @Indexed(background = true)
    private String personId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Valid
    private Address address;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonModel)) return false;
        PersonModel that = (PersonModel) o;
        return Objects.equals(getPersonId(), that.getPersonId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getFirstName(), getLastName(), getAddress());
    }
}
