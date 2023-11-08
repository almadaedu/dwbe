package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Category;
import com.dwbe.hotelaria.model.Room;
import com.dwbe.hotelaria.repositories.CategoryRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
