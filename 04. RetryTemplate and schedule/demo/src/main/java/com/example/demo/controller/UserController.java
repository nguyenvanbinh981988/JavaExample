package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.service.SV.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1,"Nguyễn Thị Mộng Mơ","MongMo@gmail.com.vn","0987654321","avatar1.jpn","123"));
        users.add(new User(2,"Nguyễn Thị Hằng","Hang@gmail.com.vn","0123456789","avatar2.jpn","321"));
        users.add(new User(3,"Nguyễn Thị Trà My","TraMy@gmail.com.vn","0987656789","avatar3.jpn","123"));
    }


//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        return ResponseEntity.ok(userService.getListUser());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id){
        System.out.println("Retry OK");
        List<UserDto> result = new ArrayList<>();
        for (User user : users){
            if(user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại trên hệ thống");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "keyword", required = false, defaultValue = "") String name){
        return ResponseEntity.ok(userService.searchUser(name));
    }
}
