package com.nido.back.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nido.back.application.dtos.UserRequest;
import com.nido.back.application.dtos.UserResponse;
import com.nido.back.application.exceptions.ResourceNotFoundException;
import com.nido.back.application.mapper.UserMapper;
import com.nido.back.domain.model.User;
import com.nido.back.domain.repository.IUserRespository;

@Service
public class UserService {

    private final IUserRespository _iUserRespository;
    private final UserMapper _userMapper;

    public UserService(
            IUserRespository iUserRespository,
            UserMapper userMapper) {
        _iUserRespository = iUserRespository;
        _userMapper = userMapper;
    }

    public List<UserResponse> listar() {
        return _iUserRespository.getAll()
                .stream()
                .map(_userMapper::toResponse)
                .toList();
    }

    public UserResponse getById(Long id) {
        return _iUserRespository.findById(id)
                .map(_userMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserResponse postUser(UserRequest request) {
        User saved = _iUserRespository.save(_userMapper.toDomain(request));
        return _userMapper.toResponse(saved);
    }

}
