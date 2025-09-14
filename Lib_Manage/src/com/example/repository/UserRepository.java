package com.example.repository;

import com.example.entity.User;
import java.util.List;

public interface UserRepository {
    void addUser(User user);
    User getUserById(long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUserById(long id);
    void deleteUserByUsername(String username);
}
