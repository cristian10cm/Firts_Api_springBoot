package com.cruz.medicaments_api.users.controller;

import com.cruz.medicaments_api.users.dto.CreateUserDto;
import com.cruz.medicaments_api.users.dto.UpdateUserDto;
import com.cruz.medicaments_api.users.dto.UserResponseDto;
import com.cruz.medicaments_api.users.services.userService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    private final userService Userservice;
     userController(userService Userservice){
         this.Userservice = Userservice;
     }

    @GetMapping
    public List<UserResponseDto> getAllUser(){
        return Userservice.getAllUser();
    }

    @PostMapping
    public void createUser(@Valid @RequestBody CreateUserDto dto){
         Userservice.createNewUser(dto);
    }

    @PatchMapping("/{id}")

    public UserResponseDto getById(@PathVariable String id, @Valid UpdateUserDto dto){
         Long userId = Long.parseLong(id);
         return  Userservice.updateUser(userId,dto);

    }

}
