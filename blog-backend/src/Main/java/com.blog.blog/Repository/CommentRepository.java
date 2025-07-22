package com.blog.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository<Comment> extends JpaRepository<Comment, UUID> {
}