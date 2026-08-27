package com.UserFriendApplication.service.impl;

import com.UserFriendApplication.entity.User;
import com.UserFriendApplication.repository.UserRepository;
import com.UserFriendApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null || (user.getPassword() != null && !user.getPassword().isBlank())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            String existingPassword = userRepository.findById(user.getId())
                    .map(User::getPassword).orElse("");
            user.setPassword(existingPassword);
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
