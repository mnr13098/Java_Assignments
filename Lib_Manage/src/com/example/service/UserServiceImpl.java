package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.repository.UserRepositoryImpl;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    public void addUser(User user) {
        userRepository.addUser(user);
        System.out.println("User added successfully: " + user.getUsername());
    }


    public User findUserById(long id) {
        return userRepository.getUserById(id);
    }


    public User findUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public List<User> listAllUsers() {
        return userRepository.getAllUsers();
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
        System.out.println("User updated successfully: " + user.getUsername());
    }

    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);
        System.out.println("User with id " + id + " deleted.");
    }


    public void deleteUserByUsername(String username) {
        userRepository.deleteUserByUsername(username);
        System.out.println("User with username '" + username + "' deleted.");
    }
}
