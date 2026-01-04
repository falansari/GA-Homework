package com.ga.todo.repositories;

import com.ga.todo.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    /**
     * Find a specific item belonging to a specific user.
     * @param userId Long
     * @return Item
     */
    Item findByIdAndUserId(Long itemId, Long userId);

    /**
     * Find all items belonging to a specific category for a specific user.
     * @param categoryId Long
     * @param userId Long
     * @return List of Item
     */
    List<Item> findByCategoryIdAndUserId(Long categoryId, Long userId);

    /**
     * Replaces findAll() to find all items belonging to a specific user.
     * @param userId Long
     * @return List of Item
     */
    List<Item> findByUserId(Long userId);
}
