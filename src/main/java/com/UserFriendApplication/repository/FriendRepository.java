package com.UserFriendApplication.repository;

import com.UserFriendApplication.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findByUserId(Long userId);
}
