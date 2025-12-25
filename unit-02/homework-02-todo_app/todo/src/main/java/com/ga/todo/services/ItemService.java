package com.ga.todo.services;

import com.ga.todo.exceptions.InformationNotFoundException;
import com.ga.todo.models.Category;
import com.ga.todo.models.Item;
import com.ga.todo.repositories.CategoryRepository;
import com.ga.todo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Get list of all items in database service.
     * @return List
     */
    public List<Item> getItems() {
        System.out.println("Service calling getItems ==>");

        return itemRepository.findAll();
    }

    /**
     * Get list of all Items belonging to a specific category service.
     * @param categoryId Long
     * @return List
     */
    public List<Item> getItemsByCategory(Long categoryId) {
        System.out.println("Service calling getItemsByCategory ==>");

        return itemRepository.findByCategoryId(categoryId);
    }

    /**
     * Create a new item in database from object service.
     * @param categoryId Long
     * @param item Item
     * @return Item
     */
    public Item createItem(Long categoryId, Item item) {
        System.out.println("Service calling createItem ==>");

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException("Category with ID " + categoryId + " not found"));

        item.setCategory(category);
        return itemRepository.save(item);
    }

    /**
     * Get one item by its unique ID service.
     * @param itemId Long
     * @return Item
     */
    public Item getItem(Long itemId) {
        System.out.println("Service calling getItem ==>");

        return itemRepository.findById(itemId)
                .orElseThrow(() -> new InformationNotFoundException("Item with ID " + itemId + " not found"));
    }

    /**
     * Get item's category service.
     * @param itemId Long
     * @return Category
     */
    public Category getItemCategory(Long itemId) {
        System.out.println("Service calling getItemCategory ==>");

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new InformationNotFoundException("Item with ID " + itemId + " not found"));

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

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new InformationNotFoundException("Item with ID " + itemId + " not found"));

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

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new InformationNotFoundException("Category with ID " + itemId + " not found"));

        itemRepository.delete(item);
    }
}
