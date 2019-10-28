package com.example.spingreminder.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController("/users")
public class UserController {

    private List<User> userList;

    @Autowired // zamieniamy userList, ktora mam tylko tutaj na userService odwolujacy sie do serwera
    private UserService userService;

    @Autowired
    private Encryptor encryptor;

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user) throws NoSuchAlgorithmException {
        userService.addUser(user);
    }

    @GetMapping("/getusers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getbypswd")
    public User getUserByPassword(@RequestParam("password") String password) {
        return userService.getUserByPassword(password);
    }

}
