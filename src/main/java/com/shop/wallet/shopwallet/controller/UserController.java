package com.shop.wallet.shopwallet.controller;

import com.shop.wallet.shopwallet.entity.User;
import com.shop.wallet.shopwallet.payloads.ApiResponse;
import com.shop.wallet.shopwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;

   //method to create user
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody User user) {
        User user1 = this.userService.createUser(user);
        ApiResponse apiResponse = new ApiResponse("User created successfully !! ",true);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }

    //method to get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<User>(this.userService.getUserById(userId), HttpStatus.OK);
    }

    //method to get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(this.userService.getAllUsers(),HttpStatus.OK);
    }

    //method to update user
    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody User user) {
        this.userService.updateUser(user);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User updated successfully !!",true), HttpStatus.OK );
    }

    //method to find user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("email") String email) {
       return new ResponseEntity<User>(this.userService.getUserByEmail(email),HttpStatus.OK);
    }

    //method to delete user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully !! ", true),HttpStatus.OK);
    }


}
