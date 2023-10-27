package com.ertikmen.repository;

import com.ertikmen.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepository  implements ICrud<User>{

    @Override
    public User save(User user) {
        return null;
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
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
