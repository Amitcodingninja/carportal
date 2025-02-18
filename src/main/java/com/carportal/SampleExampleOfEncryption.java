package com.carportal;

import org.springframework.security.crypto.bcrypt.BCrypt;

// For Practice the Encryption and decryption this is not in code

public class SampleExampleOfEncryption {
    public static void main(String[] args) {
//        PasswordEncoder encrypt = new BCryptPasswordEncoder();
//        System.out.println(encrypt.encode("Amit"));
//
//
//        String hashedPassword = "$2a$10$6oGcn8kAgp/If/WAEI0qjuPC.3wpADtrv3G9W5Ju/PBEYFoHaXJQ6";
//
//        // Actual password jo check karna hai
//        String rawPassword = "Amit"; // Yaha apna original password hai
//
//        // BCrypt Encoder instance
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        // Verify password
//        boolean isMatch = encoder.matches(rawPassword, hashedPassword);
//
//        // Print result
//        if (isMatch) {
//            System.out.println("Password match ho gaya! ✅");
//        } else {
//            System.out.println("Password match nahi hua! ❌");
//        }

        String pass = BCrypt.hashpw("Amit", BCrypt.gensalt(10));// Kmse kam 10 gensalt chahiye
        System.out.println(pass);

    }
}
