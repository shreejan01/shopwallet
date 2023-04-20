package com.shop.wallet.shopwallet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Username must be min of 2 characters !!")
    private String username;

    @NotEmpty
    @Size(min = 4, max = 10, message = "Password must be min of 4 chars and max of 10 chars !!")
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Email(message = "Your email address is not valid")
    @Column(name = "email")
    private String email;

    private String address;
    private boolean status = true;
    private String profile;


}
