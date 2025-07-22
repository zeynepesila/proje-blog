package com.blog.blog.Service;

import com.blog.blog.Model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(UUID id);
    Object createComment(Comment comment);
    void deleteComment(UUID id);
}
