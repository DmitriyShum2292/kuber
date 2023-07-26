package com.course.user.controller;

import com.course.user.dto.UserDTO;
import com.course.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity getUser (@PathVariable long id) {
        UserDTO userDTO = userService.findUserById(id);
        if (userDTO == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postUser (@RequestBody UserDTO userDTO) {
        if (userDTO.getName() == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        userService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser (@PathVariable long id, @RequestBody UserDTO userDTO) {
        if (userDTO.getName() == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if (userService.findUserById(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userService.updateUser(id, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser (@PathVariable long id) {
        if (userService.findUserById(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity addPost (@PathVariable long id) {
            userService.addPost(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @DeleteMapping("/{id}/posts")
    public ResponseEntity deletePost (@PathVariable long id) {
        try {
            userService.addPost(id);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
