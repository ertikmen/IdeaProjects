package com.bilgeadam.controller;

import com.bilgeadam.repository.ICrud;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController implements ICrud<User> {

    private  UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @Override
    public User save(User user) {
        return  userService.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    public Optional<User> findByUsername(String username) {
        return  userService.findByUsername(username);
    }
}
