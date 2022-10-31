package com.example.demo;


import com.example.demo.model.Status;
import com.example.demo.model.User;
import com.example.demo.respository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

//@SpringBootTest
public class TestUserRepo {
    @Test
    public void addUser(){
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("John Levy","levy@gmail.com","Nvb123", Status.ACTIVE);
        assertThat(user).isNotNull();
        System.out.println(user.getId());
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void addUserWithPendingState(){
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("John Levy","levy@gmail.com","Nvb123");
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotBlank();
        assertThat(user.getStatus()).isEqualTo(Status.PENDING);
        System.out.println(user.getStatus());
    }

//    test email có tồn tại chưa?
    @Test
    public void isEmailExist(){
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("John Levy","levy@gmail.com","Nvb123");
        userRepo.addUser("Bon Nevi","Nevi@gmail.com","Nvb123");
        userRepo.addUser("Jon Devi","Devi@gmail.com","Nvb123");
        assertThat(userRepo.isEmailExist("Levy@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("vy@gmail.com")).isFalse();
        System.out.println("ok");
    }

    //    tìm user có theo Email
    @Test
    public void findByEmail(){
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("John Levy","levy@gmail.com","Nvb123");
        userRepo.addUser("Bon Nevi","Nevi@gmail.com","Nvb123");
        userRepo.addUser("Jon Devi","Devi@gmail.com","Nvb123");

        assertThat(userRepo.findByEmail("Levy@gmail.com")).isPresent();
        assertThat(userRepo.findByEmail("Nevi@gmail.com")).isPresent();
        assertThat(userRepo.findByEmail("Devi@gmail.com")).isPresent();
        System.out.println("ok");

    }

}
