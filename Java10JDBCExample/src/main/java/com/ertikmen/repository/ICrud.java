package com.ertikmen.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {

    void save(T t);
    void update(T t);
    void deleteById(Long id);
    List<T> findAll();
    Optional<T> findById(Long id);

}
