package com.nido.back.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.domain.model.Category;
import com.nido.back.infrastructure.persistence.entity.CategoryEntity;

@Component
public class CategoryEntityMapper {

    public CategoryEntity toEntity(Category domain) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(domain.getId());
        categoryEntity.setName(domain.getName());
        categoryEntity.setTransactionType(domain.getTransactionType());
        return categoryEntity;
    }

    public Category toDomain(CategoryEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        category.setTransactionType(entity.getTransactionType());
        return category;
    }

}
