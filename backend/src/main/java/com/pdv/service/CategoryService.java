package com.pdv.service;

import com.pdv.dto.CategoryCreateDTO;
import com.pdv.entity.Category;
import com.pdv.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category create(CategoryCreateDTO dto) {

        Category category = Category.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .description(dto.getDescription())
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(category);
    }

    public List<Category> list() {
        return repository.findAll();
    }

}