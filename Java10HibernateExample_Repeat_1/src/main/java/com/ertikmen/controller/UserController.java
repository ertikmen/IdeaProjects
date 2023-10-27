package com.ertikmen.controller;

import com.ertikmen.repository.ICrud;
import com.ertikmen.repository.entity.User;
import com.ertikmen.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController implements ICrud<User> {

    private final UserService userService;


    public UserController() {
        this.userService = new UserService();
    }

    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long Id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long Id) {
        return Optional.empty();
    }
}
