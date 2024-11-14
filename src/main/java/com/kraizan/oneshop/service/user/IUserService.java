package com.kraizan.oneshop.service.user;

import com.kraizan.oneshop.dto.UserDto;
import com.kraizan.oneshop.model.User;
import com.kraizan.oneshop.request.CreateUserRequest;
import com.kraizan.oneshop.request.UpdateUserRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UpdateUserRequest request, Long userId);
    void deleteUser(Long userId);
    UserDto convertUserToDto(User user);
    User getAuthenticatedUser();
}
