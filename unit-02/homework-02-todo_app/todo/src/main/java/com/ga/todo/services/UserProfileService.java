package com.ga.todo.services;

import com.ga.todo.exceptions.InformationNotFoundException;
import com.ga.todo.models.User;
import com.ga.todo.models.UserProfile;
import com.ga.todo.repositories.UserProfileRepository;
import com.ga.todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private UserProfileRepository userProfileRepository;

    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        assert userDetails != null;
        return userDetails.getUser();
    }

    /**
     * Get user's profile data
     * @return UserProfile
     */
    public UserProfile getUserProfile() {
        System.out.println("Service calling getUserProfile ==>");

        return userProfileRepository.findByUserId(getCurrentLoggedInUser().getId());
    }

    /**
     * Update user profile's information.
     * @param updatedProfile UserProfile
     * @return UserProfile
     */
    public UserProfile updateUserProfile(UserProfile updatedProfile) {
        System.out.println("Service calling updateUserProfile ==>");

        if (getCurrentLoggedInUser() == null) throw new InformationNotFoundException("You must be logged in to access your user profile.");

        UserProfile userProfile = userProfileRepository.findByUserId(getCurrentLoggedInUser().getId());

        if (userProfile == null) throw new InformationNotFoundException("A profile for user with ID " + getCurrentLoggedInUser().getId() + " was not found");

        if (updatedProfile.getFirstName() != null) userProfile.setFirstName(updatedProfile.getFirstName());
        if (updatedProfile.getLastName() != null) userProfile.setLastName(updatedProfile.getLastName());
        if (updatedProfile.getProfileDescription() != null) userProfile.setProfileDescription(updatedProfile.getProfileDescription());

        return userProfileRepository.save(userProfile);
    }
}
