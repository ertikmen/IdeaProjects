package com.ertikmen.service;

import com.ertikmen.repository.IUserRepository;
import com.ertikmen.repository.entity.UserProfile;
import com.ertikmen.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class UserService extends ServiceManager<UserProfile, String> {

    private final IUserRepository userRepository;




    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }


}
