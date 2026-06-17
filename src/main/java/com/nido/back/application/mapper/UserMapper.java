package com.nido.back.application.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.application.dtos.UserRequest;
import com.nido.back.application.dtos.UserResponse;
import com.nido.back.domain.model.User;

@Component
public class UserMapper {
    public User toDomain(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public UserResponse toResponse(User domain) {
        UserResponse response = new UserResponse();
        response.setId(domain.getId());
        response.setName(domain.getName());
        response.setEmail(domain.getEmail());
        return response;
    }
}
