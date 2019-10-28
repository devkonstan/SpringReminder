package com.example.spingreminder.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    Encryptor encryptor;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) throws NoSuchAlgorithmException {
        if (user.getLogin().length() > 4) {
            user.setPassword(new String(encryptor.encrypt(user.getPassword())));
            return userRepo.save(user); //dodaje do bazy danych
        }
        return user;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserByPassword(String password) {
        return userRepo.getUserByPassword(password).get(0); //zwroci tylko 1. uzytkownika
    }
}

