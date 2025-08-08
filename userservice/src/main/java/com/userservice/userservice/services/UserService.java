package com.userservice.userservice.services;

import java.util.List;

import com.userservice.userservice.models.entities.User;

public interface UserService {
    
    //create
    User saveUser(User user);

    //getAllUsers
    List<User> getAllUser();

    //getSingleUserOfGivenUserID
    User getUser(String userId);

}
