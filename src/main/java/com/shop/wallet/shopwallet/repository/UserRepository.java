package com.shop.wallet.shopwallet.repository;

import com.shop.wallet.shopwallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    //method to find user by username
   // User findByEmail(String email);

    //find user email if exists
    @Query("select u.email from User u where u.email = :key")
    String  findByEmail(@Param("key") String email);


}
