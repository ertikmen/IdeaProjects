package com.ertikmen.controller;

import com.ertikmen.repository.entity.Book;
import com.ertikmen.repository.entity.Borrow;
import com.ertikmen.repository.entity.UserInformation;
import com.ertikmen.service.UserInformationService;

import java.util.List;

public class UserInformationController {

    private UserInformationService userInformationService;

    public UserInformationController() {
        this.userInformationService = new UserInformationService();
    }

    public UserInformation save(UserInformation userInformation){
        return userInformationService.save(userInformation);
    }


    public List<UserInformation> findAll(){
        return userInformationService.findAll();
    }

}
