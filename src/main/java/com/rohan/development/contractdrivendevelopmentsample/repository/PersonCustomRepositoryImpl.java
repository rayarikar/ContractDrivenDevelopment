package com.rohan.development.contractdrivendevelopmentsample.repository;

import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonCustomRepositoryImpl implements PersonCustomRepository {

    private final PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonCustomRepositoryImpl.class);

    @Autowired
    public PersonCustomRepositoryImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Optional<PersonModel> findByPersonId(String personId) {
        LOGGER.info("Finding Person with personId={}", personId);
        Optional<PersonModel> personModelOptional = personRepository.findById(personId);
        if (personModelOptional.isPresent()) {
            LOGGER.info("Person found with personId={}", personId);
            return personModelOptional;
        }
        LOGGER.info("No person found with personId={}", personId);
        return personModelOptional;
    }

    @Override
    public PersonModel savePerson(PersonModel personModel) {
        LOGGER.info("Attempting to save person with personId={}", personModel.getPersonId());
        PersonModel savedPerson = personRepository.save(personModel);
        return savedPerson;
    }

    @Override
    public List<PersonModel> getAllPersons() {
        LOGGER.info("Getting all people ids");
        List<PersonModel> allPersonModels = personRepository.findAll();
        return allPersonModels;
    }

    @Override
    public PersonModel deletePersonById(String personId) {
        LOGGER.info("Repository - Looking to delete person with personId={}", personId);
        Optional<PersonModel> personModelOptional = personRepository.findById(personId);
        if (!personModelOptional.isPresent()) {
            LOGGER.info("Person not found with personId={}", personId);
            return null;
        }
        personRepository.deleteById(personId);
        return personModelOptional.get();
    }
}
