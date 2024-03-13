package net.javaguide.springbootrestfulwebservice.service;

import net.javaguide.springbootrestfulwebservice.dto.UserDto;
import net.javaguide.springbootrestfulwebservice.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);
}
