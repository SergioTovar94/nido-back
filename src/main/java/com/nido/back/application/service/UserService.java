package com.nido.back.application.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nido.back.application.dtos.UserRequest;
import com.nido.back.application.dtos.UserResponse;
import com.nido.back.application.exceptions.ResourceNotFoundException;
import com.nido.back.application.mapper.UserMapper;
import com.nido.back.domain.model.Role;
import com.nido.back.domain.model.User;
import com.nido.back.domain.repository.IRoleRepository;
import com.nido.back.domain.repository.IUserRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final IUserRespository _iUserRespository;
    private final UserMapper _userMapper;
    private final IRoleRepository iRoleRepository;
    private final PasswordEncoder passwordEncoder;

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
        User user = _userMapper.toDomain(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role defaultRole = iRoleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));
        user.setRoles(Set.of(defaultRole));
        User saved = _iUserRespository.save(user);
        return _userMapper.toResponse(saved);
    }

    public void deleteUser(Long id) {
        if (!_iUserRespository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }
        _iUserRespository.deleteUser(id);
    }

}
