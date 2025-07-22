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

    public <Post> List<Post> getAllPosts() {

        return postRepository.findAll();
    }

    @PostMapping
    public <Post> Post createPost(@RequestBody Post post) {
        post.toString ();
        return postRepository.save(post);
    }

    public <Post> Post getPostById(@PathVariable UUID id) {

        return postRepository.findById(id).orElse(null);
    }
}