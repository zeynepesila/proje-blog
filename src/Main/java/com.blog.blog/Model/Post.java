package com.blog.blog.Model;

import com.blog.blog.model.User;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private UUID postId;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    private String title;
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String content;

    public UUID getPostId() {

        return postId;
    }

    public void setPostId(UUID postId) {

        this.postId = postId;
    }

    public User getAuthor() {

        return author;
    }

    public void setAuthor(User author) {

        this.author = author;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getSummary() {

        return summary;
    }

    public void setSummary(String summary) {

        this.summary = summary;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }
}