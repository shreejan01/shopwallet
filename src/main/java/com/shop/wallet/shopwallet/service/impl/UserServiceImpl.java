package com.shop.wallet.shopwallet.service.impl;

import com.shop.wallet.shopwallet.entity.User;
import com.shop.wallet.shopwallet.exceptions.ResourceFoundException;
import com.shop.wallet.shopwallet.exceptions.ResourceNotFoundException;
import com.shop.wallet.shopwallet.repository.UserRepository;
import com.shop.wallet.shopwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;


    //method to create user
    @Override
    public User createUser(User user) {

        //check if user already exists
        if (this.checkIfUserAlreadyExits(user.getEmail())) {
            //if already exists throwing an exception
            throw new ResourceFoundException("User","email",user.getEmail());
        } else {
            //if not exits, create user
           return this.userRepo.save(user);
        }

    }


    //method to get user by id
    @Override
    public User getUserById(Long userId) {
        return this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
    }

    //method to get all users
    @Override
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    //method to update user
    @Override
    public User updateUser(User user) {
        //get user
        User user1 = this.getUserById(user.getId());
        //update values
        user1.setUsername(user.getUsername());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAddress(user.getAddress());
        user1.setProfile(user.getProfile());
        //save user
        return this.userRepo.save(user1);
    }

    //method to get user by email
    @Override
    public User getUserByEmail(String email) {
        // User user = this.userRepo.findByEmail(email);
//         if (user!=null) {
//             return user;
//         } else {
//             throw new ResourceNotFoundException("User","email",email);
//         }
        return null;
    }

    //method to delete user by id
    @Override
    public void deleteUser(Long userId) {
        User user = this.getUserById(userId);
        this.userRepo.delete(user);
    }


    //check if user already exists
    private boolean checkIfUserAlreadyExits(String email) {
        String userEmail = this.userRepo.findByEmail(email);
        return userEmail != null;
    }


}
