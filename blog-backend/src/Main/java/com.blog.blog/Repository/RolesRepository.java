package com.blog.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<com.blog.blog.Model.Roles, UUID> {
}