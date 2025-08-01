package com.blog.blog.Controller;

import com.blog.blog.DTO.RegisterRequest;
import com.blog.blog.Model.Role;
import com.blog.blog.Model.User;
import com.blog.blog.Repository.RoleRepository;
import com.blog.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.crypto.bcrypt

//.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {
        User user = userRepository.findByEmail(loginUser.getEmail());
        if (user != null && passwordEncoder.matches(loginUser.getPasswordHash(), user.getPasswordHash())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()) != null) {
            return "Email already exists";
        }

        User user = new User();
        user.setName(request.getUsername());
        user.setEmail(request.getEmail());

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        user.setPasswordHash(encodedPassword);

        Optional<Role> optionalRole = roleRepository.findByName("ROLE_USER");

        Role role;
        if (optionalRole.isPresent()) {
            role = optionalRole.get();
        } else {
            throw new RuntimeException("Role not found");
        }

        user.setRole(role);

        userRepository.save(user);
        return "Registration successful";
    }

}
