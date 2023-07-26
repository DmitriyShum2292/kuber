package com.course.user.mapper;


import com.course.user.dto.UserDTO;
import com.course.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User userDTOToUser (UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        return user;
    }

    public UserDTO userToUserDto (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAmountOfPosts(user.getAmountOfPosts());
        return userDTO;
    }
}
