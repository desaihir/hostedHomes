// UserService.java
package com.example.service;

import com.example.pojo.User;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameOrEmail(String username, String email);
    void save(User user);
    boolean usernameExists(String username);
    boolean emailExists(String email);
    boolean isValidLogin(String username, String password);
    void registerUser(User user);
    void updateUser(User user);
    void deleteUser(String username);
}
