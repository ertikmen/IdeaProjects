package com.bilgeadam.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T>  {
    T save(T t);
    T update(T t);
    void deleteById(Long id );
    List<T> findAll();
    Optional<T> findById(Long id);
}
