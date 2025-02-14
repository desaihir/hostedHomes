// UserRepository.java
package com.example.dao;

import com.example.pojo.User;

public interface UserRepository {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameOrEmail(String username, String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User save(User user);
    void delete(User user);
}
