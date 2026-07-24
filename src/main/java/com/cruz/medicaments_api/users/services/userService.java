package com.cruz.medicaments_api.users.services;

import com.cruz.medicaments_api.users.dto.CreateUserDto;
import com.cruz.medicaments_api.users.dto.UpdateUserDto;
import com.cruz.medicaments_api.users.dto.UserResponseDto;
import com.cruz.medicaments_api.users.entity.User;
import com.cruz.medicaments_api.users.mapper.userMapper;
import com.cruz.medicaments_api.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    // Use UserMapper for mapping data in repository with Record
    private final UserRepository userRepository;
    private final userMapper UserMapper;
    public userService(UserRepository userRepository, userMapper UserMapper){
        this.userRepository = userRepository;
        this.UserMapper = UserMapper;
    }
    public List<UserResponseDto> getAllUser(){
        return   UserMapper.toDtoList(
                userRepository.findAll()
        );
    }
    //The mapper changes dto to Entity, here just arrives dto from controller.
    public void createNewUser(CreateUserDto dto){
        userRepository.save(UserMapper.toEntity(dto));
    }

    public UserResponseDto getById(long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
        return UserMapper.toDto(user);
    }

    public UserResponseDto updateUser(long id, UpdateUserDto dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (dto.name() != null) {
            user.setName(dto.name());
        }

        if (dto.password() != null) {
            user.setPassword(dto.password());
        }

        User updatedUser = userRepository.save(user);

        return UserMapper.toDto(updatedUser);
    }
}
