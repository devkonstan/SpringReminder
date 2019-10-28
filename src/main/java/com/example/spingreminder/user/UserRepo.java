package com.example.spingreminder.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

                                            // <klasa, obiekt>
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> getUserByPassword(String password);
}
