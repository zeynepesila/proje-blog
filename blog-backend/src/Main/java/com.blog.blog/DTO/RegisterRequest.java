package com.blog.blog.DTO;

public class RegisterRequest {
    private String username;
    private String email;
    private String passwordHash;
    private String role;

    // Getter ve Setter'lar

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return passwordHash;
    }
    public void setPassword(String password) {
        this.passwordHash = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
