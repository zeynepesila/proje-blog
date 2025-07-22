package com.blog.blog.Service;

import com.blog.blog.Model.Roles;

import java.util.List;
import java.util.UUID;

public interface RolesService {
    List<Roles> getAllRoles();
    Roles getRoleById(UUID id);
    Roles createRole(Roles roles);
    void deleteRole(UUID id);
}
