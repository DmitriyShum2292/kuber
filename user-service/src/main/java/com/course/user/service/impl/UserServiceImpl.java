package com.course.user.service.impl;

import com.course.user.dto.UserDTO;
import com.course.user.mapper.UserMapper;
import com.course.user.model.User;
import com.course.user.repository.UserRepository;
import com.course.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO findUserById(long id) {
        Optional<User> optionalUserDTO = userRepository.findById(id);
        UserDTO userDTO = null;
        if (optionalUserDTO.isPresent()) {
            userDTO = userMapper.userToUserDto(optionalUserDTO.get());
        }
        return userDTO;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            return null;
        }
        user.setName(userDTO.getName());
        return userDTO;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addPost (long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if (user.getAmountOfPosts() == null) {
                user.setAmountOfPosts(1);
            } else {
                user.setAmountOfPosts(user.getAmountOfPosts() + 1);
            }
            userRepository.save(user);
        }
    }

    @Override
    public void deletePost(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setAmountOfPosts(user.getAmountOfPosts()-1);
            userRepository.save(user);
        }
    }
}
