package com.blog.blog.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository<Post> extends JpaRepository<Post, UUID> {
}