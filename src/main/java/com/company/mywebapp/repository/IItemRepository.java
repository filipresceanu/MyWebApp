package com.company.mywebapp.repository;

import com.company.mywebapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IItemRepository extends JpaRepository<Item,Integer> {
    Optional<Item> findByName(String name);
    Item getByid(Integer id);
}
