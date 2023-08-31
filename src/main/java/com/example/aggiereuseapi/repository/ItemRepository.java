package com.example.aggiereuseapi.repository;

import com.example.aggiereuseapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE LOWER(i.name) LIKE %:search% OR LOWER(i.category) LIKE %:search% OR LOWER(i.description) LIKE %:search% OR i.id = :id")
    List<Item> findBySearch(String search, Long id);
}
