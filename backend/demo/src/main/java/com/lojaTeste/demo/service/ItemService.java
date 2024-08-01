package com.lojaTeste.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaTeste.demo.model.Item;
import com.lojaTeste.demo.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item getById(Long id){
        Optional<Item> itemOptional = itemRepository.findById(id);

        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            return item;
        }
        return null;
    }

    public Item save(Item novoItem) {
        return itemRepository.save(novoItem);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
