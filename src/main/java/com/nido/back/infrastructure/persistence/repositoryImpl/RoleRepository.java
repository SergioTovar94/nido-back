package com.nido.back.infrastructure.persistence.repositoryImpl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nido.back.domain.model.Role;
import com.nido.back.domain.repository.IRoleRepository;
import com.nido.back.infrastructure.persistence.mapper.RoleEntityMapper;
import com.nido.back.infrastructure.persistence.repository.JpaRoleRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RoleRepository implements IRoleRepository {

    private final JpaRoleRepository jpaRoleRepository;
    private final RoleEntityMapper entityMapper;

    @Override
    public Optional<Role> findByName(String name) {
        return jpaRoleRepository.findByName(name)
                .map(entityMapper::toDomain);
    }

}
