package com.course.user.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer amountOfPosts;

    public User() {
    }

    public User(String name, Integer amountOfPosts) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(amountOfPosts, user.amountOfPosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amountOfPosts);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountOfPosts=" + amountOfPosts +
                '}';
    }
}
