package org.microservice.customerservice;

import lombok.RequiredArgsConstructor;
import org.microservice.customerservice.exception.CustomerNotFoundException;
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

    void updateCustomer(CustomerRequest request){
        var customer = customerRepository.findById(request.customerId()).orElseThrow(
                () -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID:: %s", request.customerId())
                )
        );

        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request){
        customer.setFirstname(request.firstname());
        customer.setLastname(request.lastname());
        customer.setEmail(request.email());
        customer.setAddress(request.address());
    }
}
