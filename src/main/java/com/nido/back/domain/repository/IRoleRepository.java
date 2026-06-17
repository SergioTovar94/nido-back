package com.nido.back.domain.repository;

import java.util.Optional;

import com.nido.back.domain.model.Role;

public interface IRoleRepository {

    Optional<Role> findByName(String name);

}
