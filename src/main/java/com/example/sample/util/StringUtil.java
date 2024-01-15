package com.example.sample.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class StringUtil {
    public static String passwordEncoder(String password) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");

            sha.update(password.getBytes());

            byte[] byteData = sha.digest();

            StringBuilder result_sbf = new StringBuilder();

            for(byte val : byteData) {
                result_sbf.append(Integer.toString((val & 0xff) + 0x100, 16).substring(1));
            }

            return result_sbf.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }

        return null;
    }
}
