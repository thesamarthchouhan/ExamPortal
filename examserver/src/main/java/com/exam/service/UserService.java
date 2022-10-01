package com.exam.service;

import com.exam.Model.User;
import com.exam.Model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;



public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    // Get user by username
    public User getUser(String username);

    // Deleting user by userId
    public void deleteUser(long userid);

}
