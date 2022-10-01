package com.exam.service.impl;

import com.exam.Model.User;
import com.exam.Model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        // To create a new user, first check if it already exists in the database
        User local = this.userRepository.findByUserName(user.getUserName());

        if(local!=null){
            System.out.println("User is already present. Cannot create new user with existing username.");
            throw new Exception("User already exists.");
        }else{
            // create and return new user
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRole().addAll(userRoles);
            local = this.userRepository.save(user);
            return local;
        }
    }

    // Getting user by username
    @Override
    public User getUser(String username) {

        return this.userRepository.findByUserName(username);
    }

    @Override
    public void deleteUser(long userid) {
        this.userRepository.deleteById(userid);
    }
}
