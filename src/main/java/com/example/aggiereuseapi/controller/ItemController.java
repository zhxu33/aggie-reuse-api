package com.example.aggiereuseapi.controller;

import com.example.aggiereuseapi.model.Item;
import com.example.aggiereuseapi.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Master search
    @GetMapping("/{search}")
    public ResponseEntity<List<Item>> searchItems(@PathVariable String search) {
        try {
            String lowercaseSearch = "%" + search.toLowerCase() + "%";
            Long id = search.matches("-?\\d+(\\.\\d+)?") ? Long.parseLong(search) : -1L;

            List<Item> items = itemRepository.findBySearch(lowercaseSearch, id);
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // Default search
    @GetMapping("")
    public ResponseEntity<List<Item>> getAllItems() {
        try {
            List<Item> items = itemRepository.findAll();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Create item
    @PostMapping("")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            Item newItem = itemRepository.save(item);
            return ResponseEntity.ok(newItem);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete Item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        try {
            Optional<Item> itemOptional = itemRepository.findById(id);
            if (itemOptional.isPresent()) {
                itemRepository.deleteById(id);
                return ResponseEntity.ok("Deleted item id " + id);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // Update Item
    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        try {
            Optional<Item> itemOptional = itemRepository.findById(id);
            if (itemOptional.isPresent()) {
                Item item = itemOptional.get();

                if (!updatedItem.getName().isEmpty()) {
                    item.setName(updatedItem.getName());
                }
                if (!updatedItem.getCategory().isEmpty()) {
                    item.setCategory(updatedItem.getCategory());
                }
                if (!updatedItem.getDescription().isEmpty()) {
                    item.setDescription(updatedItem.getDescription());
                }
                item.setTime(new Timestamp(System.currentTimeMillis()));
                itemRepository.save(item);
                return ResponseEntity.ok("Updated item id " + id);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}