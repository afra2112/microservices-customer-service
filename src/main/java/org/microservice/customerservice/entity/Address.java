package org.microservice.customerservice.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Address {
    @NotBlank
    private String street;
    @NotBlank
    private String houseNumber;
    @NotBlank
    private String postalCode;
}
