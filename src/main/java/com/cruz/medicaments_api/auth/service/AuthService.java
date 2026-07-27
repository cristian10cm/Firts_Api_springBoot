package com.cruz.medicaments_api.auth.service;

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
    public AuthService(
            UserRepository userRepository,
            userMapper UserMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.UserMapper = UserMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public UserResponseDto register(RegisterRequest request){
        if(userRepository.findByEmail(request.email())){
            throw  new Error("User already exist");
        }
        User user = UserMapper.toEntityRegister(request);
        user.setPassword(
                passwordEncoder.encode(request.password())
        );
        User saveU = userRepository.save(user);
        return UserMapper.toDto(saveU);
    }
}
