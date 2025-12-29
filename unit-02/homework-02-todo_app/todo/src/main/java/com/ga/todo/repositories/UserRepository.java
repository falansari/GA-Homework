package com.ga.todo.repositories;

import com.ga.todo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAddress(String userEmailAddress);
    User findUserByEmailAddress(String userEmailAddress);
    List<User> findAll();
}
