package com.example.boot_project.service;

import com.example.boot_project.exception.NotFoundException;
import com.example.boot_project.model.Category;
import com.example.boot_project.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    public Page<Category> getAll(Pageable pageable) {
        return  iCategoryRepo.findAll(pageable);
    }

    public void save(Category categories) {
        iCategoryRepo.save(categories);
    }

    public void delete(long id) {
        iCategoryRepo.deleteById(id);
    }

    public Optional<Category> findById(long id) {
        return iCategoryRepo.findById(id);
    }

    public Optional<Category> findByName(String name) {
        return iCategoryRepo.findByName(name);
    }

}
