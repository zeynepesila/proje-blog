package com.blog.blog.Controller;

import com.blog.blog.Model.Roles;
import com.blog.blog.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    // Tüm rolleri getir
    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    // ID'ye göre rol getir
    @GetMapping("/{id}")
    public Roles getRoleById(@PathVariable UUID id) {
        return RolesRepository.findById(id).orElse(null);
    }

    // Yeni rol oluştur
    @PostMapping
    public Roles createRole(@RequestBody Roles role) {
        if (role.getRoleId() == null) {
            role.setRoleId(UUID.randomUUID());
        }
        return RolesRepository.save(role);
    }

    // Rol sil
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable UUID id) {
        rolesRepository.deleteById(id);
    }
}
