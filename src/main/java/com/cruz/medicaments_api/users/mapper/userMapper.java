package com.cruz.medicaments_api.users.mapper;

import com.cruz.medicaments_api.users.dto.CreateUserDto;
import com.cruz.medicaments_api.users.dto.UpdateUserDto;
import com.cruz.medicaments_api.users.dto.UserResponseDto;
import com.cruz.medicaments_api.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface userMapper {
    UserResponseDto toDto(User user);
    List<UserResponseDto> toDtoList(List<User> users);
    void updateEntity(UpdateUserDto dto, @MappingTarget User user);
    User toEntity(CreateUserDto dto);

}
