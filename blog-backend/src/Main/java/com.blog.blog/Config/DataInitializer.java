package com.blog.blog.Config;

import com.blog.blog.Model.Role;
import com.blog.blog.Repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        createRoleIfNotExists("ROLE_USER");
        createRoleIfNotExists("ROLE_EDITOR");
        createRoleIfNotExists("ROLE_ADMIN");
    }

    private void createRoleIfNotExists(String roleName) {
        Optional<Role> existingRole = roleRepository.findByName(roleName);
        if (existingRole.isEmpty()) {
            roleRepository.save(new Role(roleName));
            System.out.println("Added role: " + roleName);
        }
    }
}
