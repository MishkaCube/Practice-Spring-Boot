package com.example.demo.mapper;

import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToUserDto(User entity);
    User userDtoToEntity(UserDTO request);
    User userCreateDtoToEntity(UserCreateDTO request);
    UserDTO userCreateDtoToDto(UserCreateDTO request);
}
