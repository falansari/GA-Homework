package com.ga.todo.repositories;

import com.ga.todo.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    /**
     * Find user's profile data.
     * @param userId Long
     * @return UserProfile
     */
    UserProfile findByUserId(Long userId);
}
