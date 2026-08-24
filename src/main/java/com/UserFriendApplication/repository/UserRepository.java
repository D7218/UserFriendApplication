package com.UserFriendApplication.repository;

import com.UserFriendApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
