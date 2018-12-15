package com.rohan.development.contractdrivendevelopmentsample.repository;

import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;

import java.util.List;
import java.util.Optional;

public interface PersonCustomRepository {
    Optional<PersonModel> findByPersonId(String personId);

    PersonModel savePerson(PersonModel personModel);

    List<PersonModel> getAllPersons();

    PersonModel deletePersonById(String personId);
}
