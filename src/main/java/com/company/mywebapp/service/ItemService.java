package com.company.mywebapp.service;

import com.company.mywebapp.model.Item;
import com.company.mywebapp.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private IItemRepository repository;

    public List<Item>listAll(){return  (List<Item>)repository.findAll();}
    public void save(Item item){repository.save(item);}

    public Optional<Item> getByid(Integer id){return  repository.findById(id);}
}
