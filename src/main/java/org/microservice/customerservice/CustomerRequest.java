package org.microservice.customerservice;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CustomerRequest(
        @NotBlank
        UUID customerId,

        @NotBlank(message = "Customer firstname is required")
        String firstname,

        @NotBlank(message = "Customer lastname is required")
        String lastname,

        @NotBlank
        @Email
        String email,

        @NotBlank
        Address address
) {
}
