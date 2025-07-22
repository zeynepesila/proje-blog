package com.blog.blog.Controller;

import com.blog.blog.model.Roles;
import com.blog.blog.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles roles) {
        roles.setRoleId(UUID.randomUUID());
        return rolesRepository.save(roles);
    }

    @GetMapping("/{id}")
    public Roles getRoleById(@PathVariable UUID id) {

        return rolesRepository.findById(id).orElse(null);
    }
}