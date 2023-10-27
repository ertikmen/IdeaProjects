package com.ertikmen.repository;

import com.ertikmen.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

}
