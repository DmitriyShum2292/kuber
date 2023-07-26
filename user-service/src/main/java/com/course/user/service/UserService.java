package com.course.user.service;

import com.course.user.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO findUserById (long id);

    UserDTO createUser (UserDTO userDTO);

    UserDTO updateUser (long id, UserDTO userDTO);

    void deleteUser (long id);

     void addPost (long id);

    void deletePost(long id);
}
