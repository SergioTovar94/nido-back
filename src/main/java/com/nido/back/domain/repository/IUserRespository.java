package com.nido.back.domain.repository;

import java.util.List;
import java.util.Optional;

import com.nido.back.domain.model.User;

public interface IUserRespository {

    List<User> getAll();

    Boolean existsById(Long id);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    User save(User user);

    void deleteUser(Long id);

}
