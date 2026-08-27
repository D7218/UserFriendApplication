package com.UserFriendApplication.service.impl;

import com.UserFriendApplication.entity.Friend;
import com.UserFriendApplication.repository.FriendRepository;
import com.UserFriendApplication.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;

    @Override
    public List<Friend> findByUserId(Long userId) {
        return friendRepository.findByUserId(userId);
    }

    @Override
    public Friend findById(Long id) {
        return friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend not found: " + id));
    }

    @Override
    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public void deleteById(Long id) {
        friendRepository.deleteById(id);
    }

    @Override
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }
}