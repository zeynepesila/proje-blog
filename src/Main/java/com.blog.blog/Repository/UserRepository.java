package com.blog.blog.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<com.blog.blog.model.User, UUID> {
}