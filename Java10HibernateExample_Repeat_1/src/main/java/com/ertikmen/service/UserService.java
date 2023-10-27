package com.ertikmen.service;

import com.ertikmen.repository.ICrud;
import com.ertikmen.repository.UserRepository;
import com.ertikmen.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService implements ICrud<User> {

    private final UserRepository userRepository;


    public UserService() {

        this.userRepository =new UserRepository();
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
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
