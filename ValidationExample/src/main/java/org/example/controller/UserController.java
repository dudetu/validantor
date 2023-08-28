package org.example.controller;

import org.example.converter.UserConverter;
import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping
    List<UserDto> getAll() {
        return userService.getAll().stream()
                .map(user -> userConverter.toDto(user)).collect(Collectors.toList());
    }

    @PostMapping
    UserDto addUser(@RequestBody UserCreateDto userCreateDto) {
        return userConverter.toDto(userService.addUser(userConverter.toEntity(userCreateDto)));

//        User user = userConverter.toEntity(userCreateDto);
//        User userEntity = userService.addUser(user);
//        UserDto userDto = userConverter.toDto(userEntity);

    }

    @GetMapping("/{id}")
    UserDto getById(@PathVariable (name = "id") long id){
        return userConverter.toDto(userService.getById(id));
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> exceptionHandler(ConstraintViolationException exception) {
        Map<String, String> map = new HashMap<>();
        exception.getConstraintViolations().forEach(error -> {
            map.put(error.getPropertyPath().toString(), error.getMessage());
        });
        return map;
    }

}

