package com.thienlong.mobilestore.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String rawPassword = "123";
        String encodedPassword = encrytePassword(rawPassword);
        System.out.println(encodedPassword);
    }

}
