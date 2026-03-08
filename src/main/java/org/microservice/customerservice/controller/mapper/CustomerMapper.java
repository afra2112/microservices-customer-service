package org.microservice.customerservice.controller.mapper;

import org.mapstruct.Mapper;
import org.microservice.customerservice.controller.dto.CustomerRequest;
import org.microservice.customerservice.controller.dto.CustomerResponse;
import org.microservice.customerservice.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer requestToEntity(CustomerRequest request);
    CustomerResponse entityToResponse(Customer customer);
}
