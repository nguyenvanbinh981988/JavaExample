package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.service.SV.UserService;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1,"Nguyễn Thị Mộng Mơ","MongMo@gmail.com.vn","0987654321","avatar1.jpn","123"));
        users.add(new User(2,"Nguyễn Thị Hằng","Hang@gmail.com.vn","0123456789","avatar2.jpn","321"));
        users.add(new User(3,"Nguyễn Thị Trà My","TraMy@gmail.com.vn","0987656789","avatar3.jpn","123"));
    }


    @Override
    public List<UserDto> getListUser(){
        List<UserDto> result = new ArrayList<>();
        for (User user : users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id){
        List<UserDto> result = new ArrayList<>();
        for (User user : users){
            if(user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại trên hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword){
        List<UserDto> result = new ArrayList<>();
        for (User user: users){
            if (user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }
}
