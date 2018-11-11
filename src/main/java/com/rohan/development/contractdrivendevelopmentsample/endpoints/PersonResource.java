package com.rohan.development.contractdrivendevelopmentsample.endpoints;

import com.rohan.development.contractdrivendevelopmentsample.dto.PersonCreationDTO;
import com.rohan.development.contractdrivendevelopmentsample.dto.PersonDTO;
import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;
import com.rohan.development.contractdrivendevelopmentsample.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@Api(value = "Person Endpoints", description = "Endpoints for Person Management")
public class PersonResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);
    private final PersonService personService;

    @Autowired
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{personId}")
    @ApiOperation(value = "Get Person by PersonId", response = PersonDTO.class)
    public PersonDTO getPersonByPersonId(@PathVariable("personId") String personId) {
        LOGGER.info("Getting person by personId={}", personId);
        return personService.fetchPersonByPersonId(personId);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "Create person", response = PersonModel.class)
    public PersonModel createPerson(@RequestBody PersonCreationDTO personCreationDTO) {
        LOGGER.info("Creating person with personId={}", personCreationDTO.getPersonId());
        return personService.persistPerson(personCreationDTO);
    }
}
