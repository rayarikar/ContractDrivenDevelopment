package com.rohan.development.contractdrivendevelopmentsample.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rohan.development.contractdrivendevelopmentsample.model.Address;
import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {
    @NotBlank
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

    public static PersonDTO toPersonDTO(PersonModel personModel) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonId(personModel.getPersonId());
        personDTO.setFirstName(personModel.getFirstName());
        personDTO.setLastName(personModel.getLastName());
        personDTO.setAddress(personModel.getAddress());
        return personDTO;
    }
}
