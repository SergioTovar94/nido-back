package com.nido.back.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.domain.model.Role;
import com.nido.back.infrastructure.persistence.entity.RoleEntity;
import com.nido.back.infrastructure.persistence.repository.JpaRoleRepository;

@Component
public class RoleEntityMapper {

    private final JpaRoleRepository jpaRoleRepository;

    public RoleEntityMapper(JpaRoleRepository roleRepository) {
        this.jpaRoleRepository = roleRepository;
    }

    public RoleEntity toEntity(Role role) {
        return jpaRoleRepository.findByName(role.name())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + role.name()));
    }

    public Role toDomain(RoleEntity entity) {
        return Role.valueOf(entity.getName());
    }

}
