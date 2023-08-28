package org.example.converter;

import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.entity.User;

public interface UserConverter {

    UserDto toDto (User user);

    User toEntity(UserCreateDto userDto);
}
