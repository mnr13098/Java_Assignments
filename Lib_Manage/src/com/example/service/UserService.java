package com.example.service;

import com.example.entity.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    User findUserById(long id);
    User findUserByUsername(String username);
    List<User> listAllUsers();
    void updateUser(User user);
    void deleteUserById(long id);
    void deleteUserByUsername(String username);
}
