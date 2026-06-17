package com.nido.back.infrastructure.persistence.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nido.back.domain.model.Role;
import com.nido.back.domain.model.User;
import com.nido.back.infrastructure.persistence.entity.UserEntity;

@Component
public class UserEntityMapper {
    private final RoleEntityMapper roleEntityMapper;

    UserEntityMapper(RoleEntityMapper roleEntityMapper) {
        this.roleEntityMapper = roleEntityMapper;
    }

    public User toDomain(UserEntity entity) {
        if (entity == null)
            return null;
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setRoles(entity.getRoles().stream()
                .map(roleEntity -> Role.valueOf(roleEntity.getName()))
                .collect(Collectors.toSet()));
        return user;
    }

    public UserEntity toEntity(User domain) {
        if (domain == null)
            return null;
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());
        entity.setRoles(domain.getRoles().stream()
                .map(roleEntityMapper::toEntity)
                .collect(Collectors.toSet()));
        return entity;
    }
}
