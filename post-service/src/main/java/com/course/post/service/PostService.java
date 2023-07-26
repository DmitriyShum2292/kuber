package com.course.post.service;


import com.course.post.dto.PostDTO;
import com.course.post.model.Post;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PostService {

    Optional<Post> findPostById (long id);
    Post savePost (PostDTO postDTO);
    Post updatePost(long id, String text);
    void deletePost(long id);

    void changeAmountOfPosts(boolean plus, long id);
}
