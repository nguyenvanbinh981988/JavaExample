package com.example.demo.hash;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class SHAHash implements Hashing{
//    chú ý đây là một lỗ hổng bảo mật, đúng ra cần phải sinh động salt
//    Sau đó lưu cả salt và hash password vào csdl!

    private String salt = "O1X-343n42mnl3905u";

    @Override
    public String hashPassword(String password){
        String generatedPassword=null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            generatedPassword=sb.toString();

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    @Override
    public Boolean validatePassword(String originalPassword, String storedPassWord){
        String hashed_password = hashPassword(originalPassword);
        return storedPassWord.equals(hashed_password);
    }
}
