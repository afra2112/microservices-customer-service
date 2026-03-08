package org.microservice.customerservice;

import java.util.UUID;

public record CustomerResponse(
        UUID customerId,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
