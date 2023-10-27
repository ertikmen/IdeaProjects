package com.ertikmen.repository;



import com.ertikmen.repository.entity.Auth;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {


    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);

    Boolean existsByUsername(String username);



}
