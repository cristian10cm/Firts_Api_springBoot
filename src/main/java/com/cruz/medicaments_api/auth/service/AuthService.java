package com.cruz.medicaments_api.auth.service;

import com.cruz.medicaments_api.auth.config.JwtService;
import com.cruz.medicaments_api.auth.dto.AuthResponse;
import com.cruz.medicaments_api.auth.dto.LoginRequest;
import com.cruz.medicaments_api.auth.dto.RegisterRequest;
import com.cruz.medicaments_api.users.dto.UserResponseDto;
import com.cruz.medicaments_api.users.entity.User;
import com.cruz.medicaments_api.users.mapper.userMapper;
import com.cruz.medicaments_api.users.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final userMapper UserMapper;
    private final JwtService jwtService;
    public AuthService(
            UserRepository userRepository,
            JwtService jwtService,
            userMapper UserMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.UserMapper = UserMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService =jwtService;
    }
    @Transactional
    public UserResponseDto register(RegisterRequest request){


        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        }


        User user = UserMapper.toEntityRegister(request);



        user.setPassword(
                passwordEncoder.encode(request.password())
        );


        User saveU = userRepository.save(user);


        return UserMapper.toDto(saveU);
    }
    @Transactional
    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(
                        () -> new RuntimeException("Usuario no encontrado")
                );


        if(!passwordEncoder.matches(
                request.password(),
                user.getPassword()
        )){
            throw new RuntimeException("Credenciales incorrectas");
        }


        String token = jwtService.generateToken(user.getEmail());


        return new AuthResponse(token);
    }
}
