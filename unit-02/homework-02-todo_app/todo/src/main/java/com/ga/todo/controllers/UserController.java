package com.ga.todo.controllers;

import com.ga.todo.models.User;
import com.ga.todo.models.requests.LoginRequest;
import com.ga.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    /**
     * Get list of all users in system. For testing only.
     * TODO: Remove in live application
     * @return List of users
     */
    @GetMapping("")
    public List<User> getUsersList() {
        System.out.println("Calling getUsersList ==>");

        return userService.getUsersList();
    }

    /**
     * Register new user. Email address must be unique.
     * @param user User
     * @return User
     */
    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        System.out.println("Calling createUser ==>");

        return userService.createUser(user);
    }

    /**
     * Login user and receive JWT token upon success.
     * @param loginRequest LoginRequest body: email, password
     * @return JWT Token
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("Calling loginUser ==>");

        return userService.loginUser(loginRequest);
    }
}
