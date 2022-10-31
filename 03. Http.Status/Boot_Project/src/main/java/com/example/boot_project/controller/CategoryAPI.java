package com.example.boot_project.controller;

import com.example.boot_project.model.Category;
import com.example.boot_project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryAPI {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public Page<Category> getPage() {
       return categoryService.getAll(PageRequest.of(0, 3));
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        categoryService.findById(id);
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        categoryService.save(category);
        return category;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        categoryService.delete(id);
        return "ok";
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        categoryService.save(category);
        return category;
    }
}