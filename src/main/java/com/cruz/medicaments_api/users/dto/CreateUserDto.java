package com.cruz.medicaments_api.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(

        @NotBlank(message = "Name is required")
        String name,

        @Email(message = "Email is not valid")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password is required")
        String password

) {
}
