package com.lojaTeste.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaTeste.demo.model.Item;
import com.lojaTeste.demo.service.ItemService;

@RestController
@RequestMapping("/itens")

@CrossOrigin("http://localhost:4200/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id) {
        if (itemService.getById(id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(item));
    }

    @PutMapping
    public ResponseEntity<Item> update(@RequestBody Item item) {
        if (itemService.getById(item.getId()) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemService.save(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (itemService.getById(id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
