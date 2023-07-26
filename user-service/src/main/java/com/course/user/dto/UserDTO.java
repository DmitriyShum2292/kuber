package com.course.user.dto;

public class UserDTO {

    private Long id;
    private String name;
    private Integer amountOfPosts;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, Integer amountOfPosts) {
        this.id = id;
        this.name = name;
        this.amountOfPosts = amountOfPosts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfPosts() {
        return amountOfPosts;
    }

    public void setAmountOfPosts(Integer amountOfPosts) {
        this.amountOfPosts = amountOfPosts;
    }
}
