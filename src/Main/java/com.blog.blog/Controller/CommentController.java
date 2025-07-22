package com.blog.blog.Controller;

import com.blog.blog.model.Comment;
import com.blog.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    // Yorumları listeleme
    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // Yeni yorum ekleme
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        comment.setCommentId(UUID.randomUUID());
        return commentRepository.save(comment);
    }

    // ID ile yorum getirme
    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable UUID id) {
        return commentRepository.findById(id).orElse(null);
    }
}
