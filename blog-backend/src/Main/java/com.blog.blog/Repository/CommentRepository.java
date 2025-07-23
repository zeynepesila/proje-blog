package com.blog.blog.Repository;

import com.blog.blog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}

