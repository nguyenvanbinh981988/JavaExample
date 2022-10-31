package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepo;
import com.example.demo.service.SV.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private Hashing hashing;

//    constructor DI
    public UserServiceImpl(UserRepo userRepo, Hashing hashing) {
        this.userRepo = userRepo;
        this.hashing = hashing;
    }

    @Override
    public User login(String email, String password){
        return null;
    }


    public boolean logout(String email){
        return false;
    }

    public User addUser(String fullName, String email,String passWord){
        return null;

    }
    public boolean activateUser(String activate_code){
        return false;
    }

    public Boolean updatePassword(String email,String password){
        return null;

    }
    public Boolean updateEmail(String email, String newEmail){
        return null;

    }

    public Optional<User> findByEmail(String email){
        return null;

    }
    public User findById(String id){
        return null;

    }


}
