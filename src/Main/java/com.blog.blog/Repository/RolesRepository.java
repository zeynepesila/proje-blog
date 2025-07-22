package com.blog.blog.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<com.blog.blog.model.Roles, UUID> {
}