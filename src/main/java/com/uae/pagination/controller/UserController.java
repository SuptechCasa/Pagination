package com.uae.pagination.controller;

import com.uae.pagination.entities.User;
import com.uae.pagination.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    UserService userService;

    @PostMapping("users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
