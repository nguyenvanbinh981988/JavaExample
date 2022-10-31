package com.example.demo;

import com.example.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;


class DemoApplicationTests {

    @Test
     public void getListUser() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();


        System.out.println(userServiceImpl.getListUser());

        System.out.println(userServiceImpl.getUserById(1).getEmail());
    }


    @Test
    public void searchName(){
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        System.out.println(userServiceImpl.searchUser("Hằng"));
    }

}
