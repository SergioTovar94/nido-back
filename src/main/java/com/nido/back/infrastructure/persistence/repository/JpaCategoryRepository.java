package com.nido.back.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nido.back.infrastructure.persistence.entity.CategoryEntity;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
