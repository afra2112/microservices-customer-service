package org.microservice.customerservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "customers")
public class Customer {

    @Id
    private UUID customerId;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
