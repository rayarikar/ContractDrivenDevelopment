package com.rohan.development.contractdrivendevelopmentsample.model;

import java.util.Objects;

public class PersonModel {
    private String personId;
    private String firstName;
    private String lastName;

    public PersonModel(String personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonModel)) return false;
        PersonModel that = (PersonModel) o;
        return Objects.equals(getPersonId(), that.getPersonId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getFirstName(), getLastName());
    }
}
