package org.microservice.customerservice.service;

import lombok.RequiredArgsConstructor;
import org.microservice.customerservice.persistence.CustomerRepository;
import org.microservice.customerservice.controller.dto.CustomerRequest;
import org.microservice.customerservice.controller.dto.CustomerResponse;
import org.microservice.customerservice.controller.mapper.CustomerMapper;
import org.microservice.customerservice.entity.Customer;
import org.microservice.customerservice.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<CustomerResponse> findAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    private void mergeCustomer(Customer customer, CustomerRequest request){
        customer.setFirstname(request.firstname());
        customer.setLastname(request.lastname());
        customer.setEmail(request.email());
        customer.setAddress(request.address());
    }

    public boolean existsById(UUID customerId) {
        return customerRepository.existsById(customerId);
    }

    public CustomerResponse findById(UUID customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::entityToResponse)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot not found with the provided ID:: %s", customerId)
                ));
    }

    public void deleteCustomer(UUID customerId) {
        customerRepository.deleteById(customerId);
    }
}
