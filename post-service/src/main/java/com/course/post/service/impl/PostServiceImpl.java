package com.course.post.service.impl;


import com.course.post.dto.PostDTO;
import com.course.post.model.Post;
import com.course.post.repository.PostRepository;
import com.course.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Value("${cluster_ip}")
    private String cluster_ip;
    @Value("${port}")
    private String port;


    @Override
    public Optional<Post> findPostById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post savePost(PostDTO postDTO) {
        Post post = new Post();
        post.setAuthorId(postDTO.getAuthorId());
        post.setText(postDTO.getText());
        post.setPostedAt(new Date());
        post.setTopic(postDTO.getTopic());
        postRepository.save(post);
        changeAmountOfPosts(true, postDTO.getAuthorId());

        return post;
    }

    @Override
    public Post updatePost(long id, String text) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.get();
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
        changeAmountOfPosts(false, id);
    }

    @Override
    public void changeAmountOfPosts(boolean plus, long id) {
        RestTemplate restTemplate = new RestTemplate();
        String URL
                = "http://" + cluster_ip+ ":" +port+ "/api/v1/users/"+id+"/posts";
        if (plus) {
            ResponseEntity <String>response
                    = restTemplate.getForEntity(URL ,String.class);
        } else {
            restTemplate.delete(URL);
        }
    }
}
