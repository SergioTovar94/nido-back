package com.nido.back.infrastructure.persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nido.back.domain.model.Category;
import com.nido.back.domain.repository.ICategoryRepository;
import com.nido.back.infrastructure.persistence.mapper.CategoryEntityMapper;
import com.nido.back.infrastructure.persistence.repository.JpaCategoryRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CategoryRepository implements ICategoryRepository {

    private final JpaCategoryRepository _jpaCategoryRepository;
    private final CategoryEntityMapper _entityCategoryMapper;

    @Override
    public List<Category> getAll() {
        return _jpaCategoryRepository.findAll()
                .stream()
                .map(_entityCategoryMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return _jpaCategoryRepository.findById(id)
                .map(_entityCategoryMapper::toDomain);
    }

}
