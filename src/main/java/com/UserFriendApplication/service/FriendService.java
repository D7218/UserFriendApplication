package com.UserFriendApplication.service;

import com.UserFriendApplication.entity.Friend;
import java.util.List;

public interface FriendService {
    List<Friend> findByUserId(Long userId);
    Friend findById(Long id);
    Friend save(Friend friend);
    void deleteById(Long id);
    List<Friend> getAllFriends();
}
