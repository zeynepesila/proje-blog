
package com.blog.blog.Service;

import com.blog.blog.Model.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(UUID id);
    User createUser(User user);
    void deleteUser(UUID id);
}