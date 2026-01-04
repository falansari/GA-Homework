package com.ga.todo.services;

import com.ga.todo.exceptions.InformationAlreadyExistsException;
import com.ga.todo.models.User;
import com.ga.todo.models.requests.LoginRequest;
import com.ga.todo.models.responses.LoginResponse;
import com.ga.todo.repositories.UserRepository;
import com.ga.todo.security.JWTUtils;
import com.ga.todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private MyUserDetails myUserDetails;
    private final AuthenticationManager authenticationManager;

    /**
     * Initialize User Service.
     * @param userRepository UserRepository
     * @param passwordEncoder PasswordEncoder BCrypt Protocol
     */
    @Autowired
    private UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder,
                        JWTUtils jwtUtils,
                        @Lazy AuthenticationManager authenticationManager,
                        @Lazy MyUserDetails myUserDetails) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
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

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        try {
            Authentication authentication = authenticationManager
                    .authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            myUserDetails = (MyUserDetails) authentication.getPrincipal();
            final String JWT = jwtUtils.generateJwtToken(myUserDetails);
            return ResponseEntity.ok(new LoginResponse(JWT));
        } catch (Exception e) {
            return ResponseEntity.ok(new LoginResponse("Error: Invalid username or password"));
        }
    }
}
