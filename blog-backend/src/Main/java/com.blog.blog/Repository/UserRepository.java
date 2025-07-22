package com.blog.blog.Repository;

import com.blog.blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<com.blog.blog.Model.User, UUID> {
    static User save(User user) {
    }
}