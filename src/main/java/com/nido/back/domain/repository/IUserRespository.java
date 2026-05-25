package com.nido.back.domain.repository;

import java.util.List;
import java.util.Optional;

import com.nido.back.domain.model.User;

public interface IUserRespository {

    List<User> getAll();

    Boolean existsById(Long id);

    Optional<User> findById(Long id);

    User save(User user);

}
