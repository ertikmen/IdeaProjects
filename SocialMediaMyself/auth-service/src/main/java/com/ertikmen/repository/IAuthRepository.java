package com.ertikmen.repository;

import com.ertikmen.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<Auth,Long> {


    Optional<Auth> findOptinalByUsernameAndPassword(String username, String password);
}
