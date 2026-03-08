package org.microservice.customerservice;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer requestToEntity(CustomerRequest request);
    CustomerResponse entityToResponse(Customer customer);
}
