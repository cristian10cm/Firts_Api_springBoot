package com.cruz.medicaments_api.shared;

public record FieldErrorResponse(
        String field,
        String message

) {
}
