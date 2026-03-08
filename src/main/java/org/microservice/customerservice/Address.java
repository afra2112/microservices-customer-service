package org.microservice.customerservice;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String postalCode;
}
