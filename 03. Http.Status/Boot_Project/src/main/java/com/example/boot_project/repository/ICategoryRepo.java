package com.example.boot_project.repository;

import com.example.boot_project.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ICategoryRepo extends PagingAndSortingRepository<Category, Long> {
    Optional<Category> findByName(String name);

}
