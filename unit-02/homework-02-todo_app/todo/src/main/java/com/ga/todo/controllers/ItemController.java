package com.ga.todo.controllers;

import com.ga.todo.models.Category;
import com.ga.todo.models.Item;
import com.ga.todo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories/")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Get list of all items in database.
     * @return List
     */
    @GetMapping("items")
    public List<Item> getItems() {
        System.out.println("Calling getItems ==>");

        return itemService.getItems();
    }

    /**
     * Get list of items belonging to category.
     * @param categoryId Long
     * @return List
     */
    @GetMapping("{categoryId}/items")
    public List<Item> getItemsByCategory(@PathVariable(name = "categoryId") Long categoryId) {
        System.out.println("Calling getItemsByCategory ==>");

        return itemService.getItemsByCategory(categoryId);
    }

    /**
     * Create a new item by passing data object.
     * @param categoryId Long
     * @param object New item object
     * @return Item
     */
    @PostMapping("{categoryId}/items")
    public Item createItem(@PathVariable(name = "categoryId") Long categoryId, @RequestBody Item object) {
        System.out.println("Calling createItem ==>");

        return itemService.createItem(categoryId, object);
    }

    /**
     * Get item by ID
     * @param itemId Long
     * @return Item
     */
    @GetMapping("items/{itemId}")
    public Item getItem(@PathVariable(name = "itemId") Long itemId) {
        System.out.println("Calling getItem ==>");

        return itemService.getItem(itemId);
    }

    /**
     * Get item's category
     * @param itemId Long
     * @return Category
     */
    @GetMapping("items/{itemId}/category")
    public Category getItemCategory(@PathVariable(name = "itemId") Long itemId) {
        System.out.println("Calling getItemCategory ==>");

        return itemService.getItemCategory(itemId);
    }

    /**
     * PATCH update item, allows partial updates.
     * @param itemId Long
     * @param object Item
     * @return Item
     */
    @PatchMapping("/items/{itemId}")
    public Item updateItem(@PathVariable(name = "itemId") Long itemId, @RequestBody Item object) {
        System.out.println("Calling updateItem ==>");

        return itemService.updateItem(itemId, object);
    }

    /**
     * Delete item by ID. Returns 1 upon successful deletion.
     * @param itemId Long
     */
    @DeleteMapping("items/{itemId}")
    public void deleteItem(@PathVariable(name = "itemId") Long itemId) {
        System.out.println("Calling deleteCategory ==>");

        itemService.deleteItem(itemId);
    }
}
