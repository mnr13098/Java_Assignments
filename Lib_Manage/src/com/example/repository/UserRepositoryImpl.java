package com.example.repository;

import com.example.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();


    public void addUser(User user) {
        user.setId(idCounter.incrementAndGet());
        users.add(user);
    }


    public User getUserById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }


    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public void updateUser(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == updatedUser.getId()) {
                users.set(i, updatedUser);
                return;
            }
        }
    }


    public void deleteUserById(long id) {
        users.removeIf(user -> user.getId() == id);
    }


    public void deleteUserByUsername(String username) {
        users.removeIf(user -> user.getUsername().equalsIgnoreCase(username));
    }
}
