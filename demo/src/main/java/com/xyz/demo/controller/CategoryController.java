package com.xyz.demo.controller;

import com.xyz.demo.domain.Category;
import com.xyz.demo.exception.RecordNotFoundException;
import com.xyz.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok( categoryService.getAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getById
            (@PathVariable Long id) throws RecordNotFoundException {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @PostMapping("/category")
    public ResponseEntity<Category> save
            (@RequestBody Category category){
        Category savedCategory = categoryService.save(category);
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteById
            (@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok(String.format("Category with id %d Deleted successfully",id));
    }

    @PutMapping("/category")
    public ResponseEntity<Category> update
            (@RequestBody Category category){
        Category savedCategory = categoryService.save(category);
        return ResponseEntity.ok(savedCategory);
    }
}
