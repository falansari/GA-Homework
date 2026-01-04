package com.ga.todo.controllers;

import com.ga.todo.models.UserProfile;
import com.ga.todo.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/users/")
public class UserProfileController {
    private UserProfileService userProfileService;

    @Autowired
    public void setUserProfileService(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    /**
     * Get logged in user's profile.
     * @return UserProfile
     */
    @GetMapping("profile")
    public UserProfile getUserProfile() {
        System.out.println("Calling getUserProfile ==>");

        return userProfileService.getUserProfile();
    }

    /**
     * Update user's profile info.
     * @return UserProfile
     */
    @PatchMapping("profile")
    public UserProfile updateUserProfile(@RequestBody UserProfile userProfile) {
        System.out.println("Calling updateUserProfile ==>");

        return userProfileService.updateUserProfile(userProfile);
    }
}
