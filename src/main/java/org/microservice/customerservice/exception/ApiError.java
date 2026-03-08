package org.microservice.customerservice.exception;

import java.util.List;

public record ApiError(
        String message,
        String path,
        int status,
        List<ValidationError> errors
) {
}
