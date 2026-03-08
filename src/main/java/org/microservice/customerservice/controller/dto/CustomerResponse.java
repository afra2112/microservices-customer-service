package org.microservice.customerservice.controller.dto;

import org.microservice.customerservice.entity.Address;

import java.util.UUID;

public record CustomerResponse(
        UUID customerId,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
