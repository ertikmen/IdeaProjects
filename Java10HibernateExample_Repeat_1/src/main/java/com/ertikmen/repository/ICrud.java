package com.ertikmen.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud <T>{

    T save (T t);
    T update(T t);
    void deleteById(Long Id);
    List<T> findAll();
    Optional<T> findById(Long Id);

}
