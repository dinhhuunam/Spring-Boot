package net.javaguide.springbootrestfulwebservice.controller;

import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservice.dto.UserDto;
import net.javaguide.springbootrestfulwebservice.entity.User;
import net.javaguide.springbootrestfulwebservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    //build create User REST API
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build get user by id REST API
    //http://localhost:8080/api/users/1
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserId(@PathVariable("id") Long userId){
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //Build Get All Users REST API
    //http://localhost:8080/api/users
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //Build Update REST API
    @PutMapping("/users/{id}")
    //http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                            @RequestBody UserDto userDto){
        userDto.setId(userId);
        UserDto updateUser = userService.updateUser(userDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    //Build Delete User REST API
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully delete!", HttpStatus.OK);
    }
}