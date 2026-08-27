package com.UserFriendApplication.service;

import com.UserFriendApplication.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);

    List<User> getAllUsers();
}
