package com.rohan.development.contractdrivendevelopmentsample.endpoints;

import com.rohan.development.contractdrivendevelopmentsample.dto.PersonDTO;
import com.rohan.development.contractdrivendevelopmentsample.model.Address;
import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;
import com.rohan.development.contractdrivendevelopmentsample.repository.PersonCustomRepository;
import com.rohan.development.contractdrivendevelopmentsample.service.PersonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PersonResourceBaseTest {

    @Autowired
    PersonResource personResource;
    PersonService personService = mock(PersonService.class);
    @MockBean
    PersonCustomRepository personCustomRepository;

    @Before
    public void setUp() {
        PersonDTO personDTO = getTestPerson();
        PersonModel personModel = getPersonModel();
        Optional<PersonModel> personModelOptional = Optional.of(personModel);
        when(personService.fetchPersonByPersonId(any())).thenReturn(personDTO);
        when(personCustomRepository.findByPersonId(any())).thenReturn(personModelOptional);

        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(personResource);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    @Test
    public void sampleTest() {
//        this sample test is needed to have atleast 1 runnable method in the file
    }

    private PersonDTO getTestPerson() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("Harry");
        personDTO.setLastName("Potter");
        personDTO.setPersonId("p123");
        Address address = new Address();
        address.setLine("123 Hogwarts Castle");
        address.setCity("Hogwarts");
        address.setState("HG");
        address.setZipCode("hp123");
        address.setCountry("UK");
        personDTO.setAddress(address);
        return personDTO;
    }

    private List<PersonDTO> getTestPersonList() {
        return Arrays.asList(getTestPerson());
    }

    private PersonModel getPersonModel() {
        PersonModel personModel = new PersonModel();
        personModel.setFirstName("Harry");
        personModel.setLastName("Potter");
        personModel.setPersonId("p123");
        Address address = new Address();
        address.setLine("123 Hogwarts Castle");
        address.setCity("Hogwarts");
        address.setState("HG");
        address.setZipCode("hp123");
        address.setCountry("UK");
        personModel.setAddress(address);
        return personModel;
    }

}
