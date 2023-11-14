package ru.kata.spring.security.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.security.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUser(Long id);
    User getUserByEmail(String email);
}
