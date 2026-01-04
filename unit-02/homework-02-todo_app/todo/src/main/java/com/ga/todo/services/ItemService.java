package com.ga.todo.services;

import com.ga.todo.exceptions.InformationNotFoundException;
import com.ga.todo.models.Category;
import com.ga.todo.models.Item;
import com.ga.todo.models.User;
import com.ga.todo.repositories.CategoryRepository;
import com.ga.todo.repositories.ItemRepository;
import com.ga.todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private CategoryRepository categoryRepository;
    private ItemRepository itemRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        assert userDetails != null;
        return userDetails.getUser();
    }

    /**
     * Get list of all items belonging to a user.
     * @return List
     */
    public List<Item> getItems() {
        System.out.println("Service calling getItems ==>");

        return itemRepository.findByUserId(getCurrentLoggedInUser().getId());
    }

    /**
     * Get list of all Items belonging to a specific category service and user.
     * @param categoryId Long
     * @return List
     */
    public List<Item> getItemsByCategory(Long categoryId) {
        System.out.println("Service calling getItemsByCategory ==>");

        return itemRepository.findByCategoryIdAndUserId(categoryId, getCurrentLoggedInUser().getId());
    }

    /**
     * Create a new item in database from object service. Duplicate notes are allowed.
     * @param categoryId Long
     * @param item Item
     * @return Item
     */
    public Item createItem(Long categoryId, Item item) {
        System.out.println("Service calling createItem ==>");

        Category category = categoryRepository.findByIdAndUserId(categoryId, getCurrentLoggedInUser().getId());

        if (category == null) throw new InformationNotFoundException("Category with ID " + categoryId + " not found");

        item.setUser(getCurrentLoggedInUser());
        item.setCategory(category);
        return itemRepository.save(item);
    }

    /**
     * Get one item by its unique ID service. Prevents unauthorized access.
     * @param itemId Long
     * @return Item
     */
    public Item getItem(Long itemId) {
        System.out.println("Service calling getItem ==>");

        Item item =  itemRepository.findByIdAndUserId(itemId, getCurrentLoggedInUser().getId());

        if (item == null) throw new InformationNotFoundException("Item with ID " + itemId + " not found");

        return item;
    }

    /**
     * Get item's category service.
     * @param itemId Long
     * @return Category
     */
    public Category getItemCategory(Long itemId) {
        System.out.println("Service calling getItemCategory ==>");

        Item item = itemRepository.findByIdAndUserId(itemId, getCurrentLoggedInUser().getId());

        if (item == null) throw new InformationNotFoundException("Item with ID " + itemId + " not found");

        return item.getCategory();
    }

    /**
     * Update the values of an existing item service.
     * @param itemId Long
     * @param object Item
     * @return Item
     */
    public Item updateItem(Long itemId, Item object) {
        System.out.println("Service calling updateItem ==>");

        Item item = itemRepository.findByIdAndUserId(itemId, getCurrentLoggedInUser().getId());

        if (item == null) throw new InformationNotFoundException("Item with ID " + itemId + " not found");

        if (object.getName() != null) item.setName(object.getName());
        if (object.getDescription() != null) item.setDescription(object.getDescription());
        if (object.getDueDate() != null) item.setDueDate(object.getDueDate());
        if (object.getCategory() != null) item.setCategory(object.getCategory());

        return itemRepository.save(item);
    }

    /**
     * Delete existing item by its ID value service. Returns 1 upon successful deletion.
     * @param itemId Long
     */
    public void deleteItem(Long itemId) {
        System.out.println("Service calling deleteItem ==>");

        Item item = itemRepository.findByIdAndUserId(itemId, getCurrentLoggedInUser().getId());

        if (item == null) throw new InformationNotFoundException("Category with ID " + itemId + " not found");

        itemRepository.delete(item);
    }
}
