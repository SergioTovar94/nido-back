package com.nido.back.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.domain.model.User;
import com.nido.back.infrastructure.persistence.entity.UserEntity;

@Component
public class UserEntityMapper {
    public User toDomain(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        return user;
    }

    public UserEntity toEntity(User domain) {
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setEmail(domain.getEmail());
        return entity;
    }
}
