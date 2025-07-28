package com.blog.blog.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "roles")  // Tablonun adı böyle olur genelde çoğul
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "role_id", updatable = false, nullable = false)
    private UUID roleId;

    @Column(nullable = false, unique = true)
    private String name;

    // Boş constructor
    //public Role() {}

    // Parametreli constructor
    public Role(String name) {
        this.name = name;
    }

    // Getter & Setter
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
