package com.ga.todo.repositories;

import com.ga.todo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * Find a category by its name and the user it belongs to.
     * @param categoryName String
     * @param userId Long
     * @return Category
     */
    Category findByNameAndUserId(String categoryName, Long userId);

    /**
     * Find a category by its ID and the user it belongs to.
     * @param categoryId Long
     * @param userId Long
     * @return Category
     */
    Category findByIdAndUserId(Long categoryId, Long userId);

    /**
     * Find all categories belonging to a specific user.
     * @param userId Long
     * @return List of Category
     */
    List<Category> findByUserId(Long userId);
}
