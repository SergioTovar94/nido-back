package com.nido.back.infrastructure.persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nido.back.domain.model.User;
import com.nido.back.domain.repository.IUserRespository;
import com.nido.back.infrastructure.persistence.entity.UserEntity;
import com.nido.back.infrastructure.persistence.mapper.UserEntityMapper;
import com.nido.back.infrastructure.persistence.repository.JpaUserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository implements IUserRespository {

    private final JpaUserRepository _jpaUserRepository;
    private final UserEntityMapper _userMapper;

    @Override
    public List<User> getAll() {
        return _jpaUserRepository.findAll()
                .stream()
                .map(_userMapper::toDomain)
                .toList();
    }

    @Override
    public Boolean existsById(Long id) {
        return _jpaUserRepository.existsById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return _jpaUserRepository.findById(id)
                .map(_userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = _userMapper.toEntity(user);
        UserEntity saved = _jpaUserRepository.save(entity);
        return _userMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return _jpaUserRepository.findByEmail(email)
                .map(_userMapper::toDomain);
    }

    @Override
    public void deleteUser(Long id) {
        _jpaUserRepository.deleteById(id);
    }

}
