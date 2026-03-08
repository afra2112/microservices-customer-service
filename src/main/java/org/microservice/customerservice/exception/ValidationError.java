package org.microservice.customerservice.exception;

public record ValidationError(
        String field,
        String message
) {
}
