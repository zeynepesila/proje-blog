package com.blog.blog;

import com.blog.blog.Model.Role;
import com.blog.blog.Model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class UserServiceTest {
    private Object Role;

    @Test
    public void testUserName() {
        User user = new User();
        user.setName("Zeynep");

        assertEquals("Zeynep", user.getName());

        user.setPasswordHash("1234Z");
        assertEquals("1234Z",user.getPasswordHash());

        user.setEmail("zeynep@zeynep");
        assertEquals("zeynep@zeynep",user.getEmail());

        Role role = new Role("Admin");
        user.setRole(role);

        assertEquals("Admin", user.getRole().getName());
    }
}






