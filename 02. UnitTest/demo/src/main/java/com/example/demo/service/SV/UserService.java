package com.example.demo.service.SV;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    public User login(String email, String password);
    public boolean logout(String email);

    public User addUser(String fullName, String email,String passWord);
    public boolean activateUser(String activate_code);

    public Boolean updatePassword(String email,String password);
    public Boolean updateEmail(String email, String newEmail);

    public Optional<User> findByEmail(String email);
    public User findById(String id);
}
