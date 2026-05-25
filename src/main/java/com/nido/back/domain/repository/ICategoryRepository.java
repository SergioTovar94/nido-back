package com.nido.back.domain.repository;

import java.util.List;
import java.util.Optional;

import com.nido.back.domain.model.Category;

public interface ICategoryRepository {

    List<Category> getAll();

    Optional<Category> findById(Long id);

}
