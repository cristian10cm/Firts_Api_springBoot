package com.cruz.medicaments_api.shared;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse (
        LocalDateTime timestamp,
        int statusCode,
        String error,
        List<FieldErrorResponse> errors
)
{

}
