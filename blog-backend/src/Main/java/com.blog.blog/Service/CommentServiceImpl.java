package com.blog.blog.Service;

import com.blog.blog.Model.Comment;
import com.blog.blog.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return CommentRepository.findAll();
    }

    @Override
    public Comment getCommentById(UUID id) {
        return CommentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {
        return CommentRepository.save(comment);
    }

    @Override
    public void deleteComment(UUID id) {
        CommentRepository.deleteById(id);
    }
}
