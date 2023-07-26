package com.course.post.validation;

import com.course.post.dto.PostDTO;
import com.course.post.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostValidator {

    public boolean validatePostDTO (PostDTO postDTO) {
        if (postDTO == null) {
            return false;
        }
        if (postDTO.getAuthorId() <= 0) {
            return false;
        }
        if (postDTO.getText().isEmpty() || postDTO.getText() == null) {
            return false;
        }
        return true;
    }

    public boolean validatePost (Post post) {
        if (post == null) {
            return false;
        }
        return true;
    }
}
