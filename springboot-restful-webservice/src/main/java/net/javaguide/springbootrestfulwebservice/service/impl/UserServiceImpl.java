package net.javaguide.springbootrestfulwebservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguide.springbootrestfulwebservice.dto.UserDto;
import net.javaguide.springbootrestfulwebservice.entity.User;
import net.javaguide.springbootrestfulwebservice.mapper.UserMapper;
import net.javaguide.springbootrestfulwebservice.repository.UserRepository;
import net.javaguide.springbootrestfulwebservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert UserDto into User JPA Entity
//        User user = new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        //Convert User JPA entity to UserDto
//        UserDto savedUserDto = new UserDto(
//                savedUser.getId(),
//                savedUser.getFirstName(),
//                savedUser.getLastName(),
//                savedUser.getEmail()
//        );
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User optionalUser =  userRepository.findById(userId).get();
        UserDto userDto = UserMapper.mapToUserDto(optionalUser);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//        for(User user : users){
//            UserDto temp = UserMapper.mapToUserDto(user);
//            userDtos.add(temp);
//        }
//        return userDtos;
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(existingUser);

        UserDto updateUserDto = UserMapper.mapToUserDto(updateUser);
        return updateUserDto;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
