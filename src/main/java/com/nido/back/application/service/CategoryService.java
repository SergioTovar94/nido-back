package com.nido.back.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nido.back.application.dtos.CategoryResponse;
import com.nido.back.application.exceptions.ResourceNotFoundException;
import com.nido.back.application.mapper.CategoryMapper;
import com.nido.back.domain.repository.ICategoryRepository;

@Service
public class CategoryService {

    private final ICategoryRepository _iCategoryRepository;
    private final CategoryMapper _categoryMapper;

    public CategoryService(
            ICategoryRepository iCategoryRepository,
            CategoryMapper categoryMapper) {
        _iCategoryRepository = iCategoryRepository;
        _categoryMapper = categoryMapper;
    }

    public List<CategoryResponse> listar() {
        return _iCategoryRepository.getAll()
                .stream()
                .map(_categoryMapper::toResponse)
                .toList();
    }

    public CategoryResponse getById(Long id) {
        return _iCategoryRepository.findById(id)
                .map(_categoryMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

}
