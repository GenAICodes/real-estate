
package com.real.estate.service;

import com.real.estate.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
