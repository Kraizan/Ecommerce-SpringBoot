package com.kraizan.oneshop.service.user;

import com.kraizan.oneshop.dto.UserDto;
import com.kraizan.oneshop.model.User;
import com.kraizan.oneshop.request.CreateUserRequest;
import com.kraizan.oneshop.request.UpdateUserRequest;

public class UserService implements IUserService{

    @Override
    public User getUserById(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public User createUser(CreateUserRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public User updateUser(UpdateUserRequest request, Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserDto convertUserToDto(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertUserToDto'");
    }

}
