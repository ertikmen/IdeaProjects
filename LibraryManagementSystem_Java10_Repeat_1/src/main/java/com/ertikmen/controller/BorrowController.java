package com.ertikmen.controller;

import com.ertikmen.repository.entity.Author;
import com.ertikmen.repository.entity.Borrow;
import com.ertikmen.service.AuthorService;
import com.ertikmen.service.BorrowService;

public class BorrowController {

  private BorrowService borrowService;

    public BorrowController() {
        this.borrowService = new BorrowService();
    }

    public Borrow save(Borrow borrow){
      borrowService.saveReturnDate(borrow);
      return   borrowService.save(borrow);
    }

}
