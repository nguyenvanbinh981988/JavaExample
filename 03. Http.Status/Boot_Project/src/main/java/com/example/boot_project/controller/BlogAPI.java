package com.example.boot_project.controller;

import com.example.boot_project.model.Blogs;
import com.example.boot_project.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogAPI {

//    @Value("uploadPart")
//    String uploadPart;

    @Autowired
    BlogService blogService;

    @GetMapping
    public Page<Blogs> getPage() {
        return blogService.getAll(PageRequest.of(0, 4));
    }

    @PostMapping
    public Blogs save(@RequestBody Blogs blogs) {
        blogService.save(blogs);
        return blogs;
    }

    @GetMapping("/{id}")
    public Blogs findById(@PathVariable long id){
        Blogs blog = blogService.findById(id).get();
        return blog;
    }

    @PostMapping("/img")
    public String img(@RequestParam MultipartFile file){
        String name = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File("D:/00. Codegym/04. Module 4/12. jQuery and AJAX/Frontend/img/"+name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "/img/" + name;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        blogService.delete(id);
        return "ok";
    }

    @PutMapping
    public Blogs update(@RequestBody Blogs blogs) {
        blogService.save(blogs);
        return blogs;
    }
}