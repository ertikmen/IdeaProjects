package com.ertikmen.repository;


import com.ertikmen.repository.entity.UserProfile;
import com.ertikmen.repository.enums.EStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends MongoRepository<UserProfile, String> {

    Boolean existsByUsername(String username);

    Optional<UserProfile> findByAuthId(Long authId);

    Optional<UserProfile> findByUsername(String username);

    List<UserProfile> findByStatus(EStatus status);

    @Query("{username: ?0,email: ?1}")
    Optional<UserProfile> getUser(String username);

    @Query("{$or: [{authId:{$gt: ?0}},{status: ?1}]}")
    Optional<UserProfile> getUserGTIdAndStatus(Long authId,EStatus status);


    @Query("{authId: {$gt: ?0}}")
    Optional<UserProfile> findUserGtId(Long authId);

    @Query("{status: 'ACTIVE'}")
    Optional<UserProfile> findActiveProfile();

}
