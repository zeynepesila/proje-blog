package com.blog.blog.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Roles {

    @Id
    @GeneratedValue
    private UUID roleId;

    @Column(nullable = false, unique = true)
    private String name;


    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
