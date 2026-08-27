package com.UserFriendApplication.controller;

import com.UserFriendApplication.entity.Friend;
import com.UserFriendApplication.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;


    @GetMapping
    public String getAllFriends(Model model) {

        List<Friend> friends = friendService.getAllFriends();

        model.addAttribute("friends", friends);

        return"friend/friends";
    }
    @GetMapping("/user/{userId}")
    public String getFriendsByUserId(
            @PathVariable Long userId,
            Model model) {

        List<Friend> friends =
                friendService.findByUserId(userId);

        model.addAttribute("friends", friends);
        model.addAttribute("userId", userId);
        return "friend/friends";
    }



    @PostMapping("/delete/{id}")
    public String deleteFriend(@PathVariable Long id) {
        friendService.deleteById(id);
        return "redirect:/friends";
    }
}