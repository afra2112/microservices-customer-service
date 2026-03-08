package org.microservice.customerservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    UUID createCustomer(CustomerRequest request){
        var customer = customerRepository.save(customerMapper.requestToEntity(request));
        return customer.getCustomerId();
    }
}
