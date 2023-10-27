package com.ertikmen.controller;

import com.ertikmen.repository.entity.Author;
import com.ertikmen.repository.entity.Users;
import com.ertikmen.service.AuthorService;
import com.ertikmen.service.UsersService;

public class AuthorController {

  private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public Author save(Author author){
      return   authorService.save(author);
    }

}
