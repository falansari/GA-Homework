package com.ga.todo.controllers;

import com.ga.todo.models.User;
import com.ga.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/auth/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsersList() {
        System.out.println("Calling getUsersList ==>");

        return userService.getUsersList();
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        System.out.println("Calling createUser ==>");

        return userService.createUser(user);
    }
}
