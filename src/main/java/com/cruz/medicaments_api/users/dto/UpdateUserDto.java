package com.cruz.medicaments_api.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserDto (
        String name,
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password
){

}
