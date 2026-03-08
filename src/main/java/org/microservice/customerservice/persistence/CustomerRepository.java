package org.microservice.customerservice.persistence;

import org.microservice.customerservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<Customer, UUID> {

}
