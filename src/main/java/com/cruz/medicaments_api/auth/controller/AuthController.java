package com.cruz.medicaments_api.auth.controller;

import com.cruz.medicaments_api.auth.dto.AuthResponse;
import com.cruz.medicaments_api.auth.dto.LoginRequest;
import com.cruz.medicaments_api.auth.dto.RegisterRequest;
import com.cruz.medicaments_api.auth.service.AuthService;
import com.cruz.medicaments_api.users.dto.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(
            AuthService authService
    ){
        this.authService = authService;
    }
    @PostMapping("/register")
    public UserResponseDto createNewUser( @Valid @RequestBody RegisterRequest user ){
        return authService.register(user);
    }
    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request
    ){
        return authService.login(request);
    }
}
