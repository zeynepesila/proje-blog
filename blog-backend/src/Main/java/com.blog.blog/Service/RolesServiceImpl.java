package com.blog.blog.Service;

import com.blog.blog.Model.Roles;
import com.blog.blog.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getRoleById(UUID id) {
        return rolesRepository.findById(id).orElse(null);
    }

    @Override
    public Roles createRole(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void deleteRole(UUID id) {
        rolesRepository.deleteById(id);
    }
}
