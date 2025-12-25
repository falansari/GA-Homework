package com.ga.todo.controllers;

import com.ga.todo.models.Category;
import com.ga.todo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<Category> getCategories() {
        System.out.println("Calling getCategories ==>");

        return categoryService.getCategories();
    }

    /**
     * Create a new category by passing data object with fields name, description.
     * @param object New category object
     * @return Category
     */
    @PostMapping("")
    public Category createCategory(@RequestBody Category object) {
        System.out.println("Calling createCategory ==>");

        return categoryService.createCategory(object);
    }

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable(name = "categoryId") Long categoryId) {
        System.out.println("Calling getCategory ==>");

        return categoryService.getCategory(categoryId);
    }

    @PatchMapping("/{categoryId}")
    public Category updateCategory(@PathVariable(name = "categoryId") Long categoryId, @RequestBody Category object) {
        System.out.println("Calling updateCategory ==>");

        return categoryService.updateCategory(categoryId, object);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable(name = "categoryId") Long categoryId) {
        System.out.println("Calling deleteCategory ==>");

        categoryService.deleteCategory(categoryId);
    }
}
