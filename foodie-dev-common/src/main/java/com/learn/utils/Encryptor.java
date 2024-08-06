package com.learn.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encryptor {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encode(CharSequence charSequence) {
        return passwordEncoder.encode(charSequence);
    }

    public static boolean matches(CharSequence charSequence, String s) {
        return passwordEncoder.matches(charSequence, s);
    }
}
