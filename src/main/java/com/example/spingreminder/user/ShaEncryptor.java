package com.example.spingreminder.user;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class ShaEncryptor implements Encryptor{

    @Override
    public byte[] encrypt(String value) throws NoSuchAlgorithmException {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    value.getBytes(StandardCharsets.UTF_8));
            return encodedhash;
        }
    }

