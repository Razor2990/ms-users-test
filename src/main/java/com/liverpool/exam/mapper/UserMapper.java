package com.liverpool.exam.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.liverpool.exam.dto.UserRequestDto;
import com.liverpool.exam.dto.UserResponseDto;
import com.liverpool.exam.entity.Address;
import com.liverpool.exam.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "direccion", expression = "java(address)")
    User toEntity(UserRequestDto dto, Address address);

    UserResponseDto toDto(User user);
}
