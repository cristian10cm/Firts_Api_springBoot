package com.cruz.medicaments_api.shared;

import java.util.List;

public record ErrorResponse (
        int statusCode,
        String error,
        List<String> message
)
{

}
