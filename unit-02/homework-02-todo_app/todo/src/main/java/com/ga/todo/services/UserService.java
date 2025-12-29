package com.ga.todo.services;

import com.ga.todo.exceptions.InformationAlreadyExistsException;
import com.ga.todo.models.User;
import com.ga.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Initialize User Service.
     * @param userRepository UserRepository
     * @param passwordEncoder PasswordEncoder BCrypt Protocol
     */
    @Autowired
    private UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsersList() {
        System.out.println("Service calling getUsersList ==>");

        return userRepository.findAll();
    }

    /**
     * Create new user service.
     * @param user User object
     * @return User
     */
    public User createUser(User user) {
        System.out.println("Service calling createUser ==>");

        if (userRepository.existsByEmailAddress(user.getEmailAddress()))
            throw new InformationAlreadyExistsException("A user with the e-maill address " + user.getEmailAddress() + " already exists");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Find user by email address service.
     * @param email String
     * @return User
     */
    public User findUserByEmailAddress(String email) {
        System.out.println("Service calling findUserByEmailAddress ==>");

        return userRepository.findUserByEmailAddress(email);
    }
}
