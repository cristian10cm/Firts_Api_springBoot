package com.cruz.medicaments_api.medicaments.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record MedicineCreateDto (
        @NotBlank(message = "name is required")
        String name,
        @Positive
        Number price,
        @Size(min = 1, max = 10,message = "Min 1 symptom and max 10")
        List<String> symptoms
){

}
