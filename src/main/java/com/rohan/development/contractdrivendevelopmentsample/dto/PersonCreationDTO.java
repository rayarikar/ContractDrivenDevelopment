package com.rohan.development.contractdrivendevelopmentsample.dto;

import com.rohan.development.contractdrivendevelopmentsample.model.Address;
import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;

import javax.validation.constraints.NotBlank;

public class PersonCreationDTO {
    @NotBlank
    private String personId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String addressLine;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String country;

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

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static PersonModel toPersonModel(PersonCreationDTO personCreationDTO) {
        PersonModel personModel = new PersonModel();
        personModel.setPersonId(personModel.getPersonId());
        personModel.setFirstName(personCreationDTO.getFirstName());
        personModel.setLastName(personCreationDTO.getLastName());
        Address address = new Address();
        address.setLine(personCreationDTO.getAddressLine());
        address.setCity(personCreationDTO.getCity());
        address.setState(personCreationDTO.getState());
        address.setZipCode(personCreationDTO.getZipCode());
        address.setCountry(personCreationDTO.getCountry());
        personModel.setAddress(address);
        return personModel;
    }
}
