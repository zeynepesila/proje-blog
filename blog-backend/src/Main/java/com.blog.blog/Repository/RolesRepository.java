package com.blog.blog.Repository;

import com.blog.blog.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface RolesRepository extends JpaRepository<Roles, UUID> {
    Optional<Roles> findByName(String name);
}
