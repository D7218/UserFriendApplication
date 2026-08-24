package com.UserFriendApplication.controller;

import com.UserFriendApplication.entity.Friend;
import com.UserFriendApplication.service.FriendService;
import com.UserFriendApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/{userId}/friends")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;
    private final UserService userService;

    @GetMapping
    public String list(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("friends", friendService.findByUserId(userId));
        return "friend/list";
    }

    @GetMapping("/new")
    public String createForm(@PathVariable Long userId, Model model) {
        Friend friend = new Friend();
        friend.setUser(userService.findById(userId));
        model.addAttribute("friend", friend);
        model.addAttribute("userId", userId);
        return "friend/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long userId, @PathVariable Long id, Model model) {
        model.addAttribute("friend", friendService.findById(id));
        model.addAttribute("userId", userId);
        return "friend/form";
    }

    @PostMapping("/save")
    public String save(@PathVariable Long userId, @ModelAttribute Friend friend) {
        friend.setUser(userService.findById(userId));
        friendService.save(friend);
        return "redirect:/users/" + userId + "/friends";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long userId, @PathVariable Long id) {
        friendService.deleteById(id);
        return "redirect:/users/" + userId + "/friends";
    }
}
