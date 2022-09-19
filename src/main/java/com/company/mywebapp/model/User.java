package com.company.mywebapp.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true,length = 45)
    private String email;

    @Column(length = 15,nullable = false)
    private String password;

    @Column(length = 45,nullable = false,name="first_name")
    private String firstName;
    @Column(length = 45,nullable = false,name="last_name")
    private String lastName;

    @OneToOne
    private Cart cart;




}
