package com.pdv.controller;

import com.pdv.dto.CategoryCreateDTO;
import com.pdv.entity.Category;
import com.pdv.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public Category create(@RequestBody CategoryCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Category> list() {
        return service.list();
    }

}