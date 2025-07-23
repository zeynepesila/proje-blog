package com.blog.blog.Controller;

import com.blog.blog.Model.Post;
import com.blog.blog.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // Tüm postları getir
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Yeni post oluştur
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // ID'ye göre post getir
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable UUID id) {
        return postRepository.findById(id).orElse(null);
    }
}
