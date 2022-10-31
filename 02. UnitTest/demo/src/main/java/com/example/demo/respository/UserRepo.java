package com.example.demo.respository;

import com.example.demo.model.Status;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepo {
    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public User addUser(String fullName, String email, String hashed_password, Status status){
        String id = UUID.randomUUID().toString();
        User user = User.builder()
                .id(id)
                .fullName(fullName)
                .email(email)
                .hashed_password(hashed_password)
                .status(status)
                .build();
        users.put(id,user);
        return user;
    }

    public User addUser(String fullName, String email, String hashed_password){
        return addUser(fullName,email,hashed_password,Status.PENDING);
    }

//    kiểm tra xem email có tồn tại trong hệ thống chưa
    public boolean isEmailExist(String email){
      return users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).count()>0;
    }

//    tìm user có theo Email
    public Optional<User> findByEmail(String email){
        return users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
