package com.shop.wallet.shopwallet.service;

import com.shop.wallet.shopwallet.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    //Creating user
    User createUser(User user);

    //get user by id
    User getUserById(Long userId);

    //get all users
    List<User> getAllUsers();

    //Update user
    User updateUser(User user);

    //Get user by email
    User getUserByEmail(String username);

    //Delete user by id
    void deleteUser(Long userId);

}
