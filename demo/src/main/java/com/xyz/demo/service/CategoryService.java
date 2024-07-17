package com.xyz.demo.service;

import com.xyz.demo.domain.Category;
import com.xyz.demo.exception.RecordNotFoundException;
import com.xyz.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {
@Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    public Category getById(Long id) throws RecordNotFoundException {
        Optional<Category> found = categoryRepository.findById(id);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new RecordNotFoundException(String.format("No Category exist on id: %id", id));
        }
    }
    public List<Category> getAll() {
        return new ArrayList<>(categoryRepository.findAll());
    }
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);

    }
}
