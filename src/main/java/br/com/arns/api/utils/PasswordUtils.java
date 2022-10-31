package br.com.arns.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    public static String encryptPassword(String password) {
        if (password.isEmpty()) {
            return password;
        } else {
            return new BCryptPasswordEncoder().encode(password);
        }
    }

    public static boolean validatePassword(String password, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(password, encodedPassword);
    }

}
