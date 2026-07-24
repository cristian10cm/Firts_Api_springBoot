package com.cruz.medicaments_api.medicaments.dto;

import java.util.List;

public record MedicineResponseDto(
        long id,
        String name,
        Number price,
        List<String> symptoms
){
}
