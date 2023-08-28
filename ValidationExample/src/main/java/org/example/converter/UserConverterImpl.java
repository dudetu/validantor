package org.example.converter;

import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getName(), user.getEmail());
    }

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return new User(userCreateDto.getName(), userCreateDto.getEmail());
    }
}
