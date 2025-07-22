package com.blog.blog.Controller;

import com.blog.blog.Model.Comment;
import com.blog.blog.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    // Tüm yorumları getir
    @GetMapping
    public List<Comment> getAllComments() {
        return CommentRepository.findAll();
    }

    // ID'ye göre yorumu getir
    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable UUID id) {
        return CommentRepository.findById(id).orElse(null);
    }

    // Yeni yorum oluştur
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        if (comment.getCommentId() == null) {
            comment.setCommentId(UUID.randomUUID());
        }
        return CommentRepository.save(comment);
    }

    // Yorumu sil
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable UUID id) {
        CommentRepository.deleteById(id);
    }
}
