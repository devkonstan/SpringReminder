package com.example.spingreminder.user;

import java.security.NoSuchAlgorithmException;

public interface Encryptor {
    byte[] encrypt(String value)throws NoSuchAlgorithmException; //najmniejszy z mozliwych typ danych
}
