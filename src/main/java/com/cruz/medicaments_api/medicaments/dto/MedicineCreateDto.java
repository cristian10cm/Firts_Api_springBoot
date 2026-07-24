package com.cruz.medicaments_api.medicaments.dto;

import java.util.List;

public record MedicineCreateDto (
        long id,
        String name,
        Number price,
        List<String> symptoms
){

}
