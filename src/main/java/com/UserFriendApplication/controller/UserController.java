package com.UserFriendApplication.controller;

import com.UserFriendApplication.entity.User;
import com.UserFriendApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
