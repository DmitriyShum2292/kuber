package com.course.post.dto;

public class PostDTO {

    private long authorId;
    private String text;

    private String topic;

    public PostDTO() {
    }

    public PostDTO(long authorId, String text, String topic) {
        this.authorId = authorId;
        this.text = text;
        this.topic = topic;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
