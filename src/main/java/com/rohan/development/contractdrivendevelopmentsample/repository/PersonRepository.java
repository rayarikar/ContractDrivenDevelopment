package com.rohan.development.contractdrivendevelopmentsample.repository;

import com.rohan.development.contractdrivendevelopmentsample.model.PersonModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends MongoRepository<PersonModel, String> {
}
