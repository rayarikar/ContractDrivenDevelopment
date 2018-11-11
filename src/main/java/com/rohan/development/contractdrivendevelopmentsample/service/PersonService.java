package com.rohan.development.contractdrivendevelopmentsample.service;

import com.rohan.development.contractdrivendevelopmentsample.dto.PersonCreationDTO;
import com.rohan.development.contractdrivendevelopmentsample.dto.PersonDTO;
import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;
import com.rohan.development.contractdrivendevelopmentsample.repository.PersonCustomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    private final PersonCustomRepository personCustomRepository;

    @Autowired
    public PersonService(PersonCustomRepository personCustomRepository) {
        this.personCustomRepository = personCustomRepository;
    }

    public PersonModel persistPerson(PersonCreationDTO personCreationDTO) {
        LOGGER.info("Saving personId={} in person collection", personCreationDTO.getPersonId());
        PersonModel personModel = PersonCreationDTO.toPersonModel(personCreationDTO);
        PersonModel savedPerson = personCustomRepository.savePerson(personModel);
        return savedPerson;
    }

    public PersonDTO fetchPersonByPersonId(String personId) {
        LOGGER.info("Getting person from Person collections by personId={}", personId);
        Optional<PersonModel> personModelOptional = personCustomRepository.findByPersonId(personId);
        if (!personModelOptional.isPresent()) {
            LOGGER.info("Person not found for personId={}. Returning null", personId);
            return null;
        }
        LOGGER.info("Returning found person for personId={}", personId);
        return PersonDTO.toPersonDTO(personModelOptional.get());
    }
}
