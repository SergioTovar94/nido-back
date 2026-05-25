package com.nido.back.application.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.application.dtos.CategoryRequest;
import com.nido.back.application.dtos.CategoryResponse;
import com.nido.back.domain.model.Category;

@Component
public class CategoryMapper {

    public Category toDomain(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setTransactionType(request.getTransactionType());
        return category;
    }

    public CategoryResponse toResponse(Category domain) {
        CategoryResponse response = new CategoryResponse();
        response.setId(domain.getId());
        response.setName(domain.getName());
        response.setTransactionType(domain.getTransactionType());
        return response;
    }

}
