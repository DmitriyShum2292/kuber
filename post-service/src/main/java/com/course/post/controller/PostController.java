package com.course.post.controller;


import com.course.post.dto.PostDTO;
import com.course.post.model.Post;
import com.course.post.service.PostService;
import com.course.post.validation.PostValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private PostValidator postValidator;

    Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/{id}")
    public ResponseEntity getPostById (@PathVariable long id) {
        Optional<Post> post = postService.findPostById(id);
        logger.info("This is really the third module =)");
        if (!post.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(post.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postPost (@RequestBody PostDTO postDTO) {
        if (!postValidator.validatePostDTO(postDTO)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(postService.savePost(postDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePost (@PathVariable long id, @RequestBody String text) {
        return new ResponseEntity(postService.updatePost(id, text), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost (@PathVariable long id) {
        postService.deletePost(id);
        if (postService.findPostById(id) == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
