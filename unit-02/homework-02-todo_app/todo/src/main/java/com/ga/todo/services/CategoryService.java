package com.ga.todo.services;

import com.ga.todo.exceptions.InformationAlreadyExistsException;
import com.ga.todo.exceptions.InformationNotFoundException;
import com.ga.todo.models.Category;
import com.ga.todo.models.User;
import com.ga.todo.repositories.CategoryRepository;
import com.ga.todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        assert userDetails != null;
        return userDetails.getUser();
    }

    /**
     * Get list of Category objects service.
     * @return List
     */
    public List<Category> getCategories() {
        System.out.println("Service calling getCategories ==>");

        return categoryRepository.findByUserId(getCurrentLoggedInUser().getId());
    }

    /**
     * Create a new category in database from object service.
     * @param object New category object
     * @return Category
     */
    public Category createCategory(Category object) {
        System.out.println("Service calling createCategory ==>");

        Category category = categoryRepository.findByNameAndUserId(object.getName(), getCurrentLoggedInUser().getId());

        if (category != null)
            throw new InformationAlreadyExistsException("Category with name " + category.getName() + " already exists.");

        object.setUser(getCurrentLoggedInUser());
        return categoryRepository.save(object);
    }

    /**
     * Get one category by its unique ID service.
     * @param categoryId Long
     * @return Category
     */
    public Category getCategory(Long categoryId) {
        System.out.println("Service calling getCategory ==>");

        Category category = categoryRepository.findByIdAndUserId(categoryId, getCurrentLoggedInUser().getId());

        if (category == null) throw new InformationNotFoundException("Category with ID " + categoryId + " not found");

        return category;
    }

    /**
     * Update the values of an existing category service.
     * @param categoryId Long
     * @param object Category
     * @return Category
     */
    public Category updateCategory(Long categoryId, Category object) {
        System.out.println("Service calling updateCategory ==>");

        Category category = categoryRepository.findByIdAndUserId(categoryId, getCurrentLoggedInUser().getId());

        if (category == null) throw new InformationNotFoundException("Category with ID " + object.getId() + " not found");

        if (object.getName() != null) {
            Category existingCategory = categoryRepository.findByNameAndUserId(object.getName(), getCurrentLoggedInUser().getId());
            if (existingCategory != null) throw new InformationAlreadyExistsException("Category with name " + existingCategory.getName() + " already exists");

            category.setName(object.getName());
        }

        if (object.getDescription() != null) category.setDescription(object.getDescription());
        return categoryRepository.save(category);
    }

    /**
     * Delete existing category by its ID value service. Returns 1 upon successful deletion.
     * @param categoryId Long
     */
    public void deleteCategory(Long categoryId) {
        System.out.println("Service calling deleteCategory ==>");

        Category category = categoryRepository.findByIdAndUserId(categoryId, getCurrentLoggedInUser().getId());

        if (category == null) throw new InformationNotFoundException("Category with ID " + categoryId + " not found");

        categoryRepository.delete(category);
    }
}
