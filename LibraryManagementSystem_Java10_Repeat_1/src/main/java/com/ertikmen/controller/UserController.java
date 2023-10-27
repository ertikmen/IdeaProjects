package com.ertikmen.controller;

import com.ertikmen.repository.entity.Users;
import com.ertikmen.service.UsersService;

public class UserController {

  private   UsersService usersService;

    public UserController() {
        this.usersService = new UsersService();
    }

    public Users save(Users users){
      return   usersService.save(users);
    }

}
