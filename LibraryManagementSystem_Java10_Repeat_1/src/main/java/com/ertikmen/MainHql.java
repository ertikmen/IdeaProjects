package com.ertikmen;

import com.ertikmen.controller.BookController;
import com.ertikmen.repository.BookRepository;
import com.ertikmen.repository.BorrowRepository;
import com.ertikmen.repository.entity.Book;
import com.ertikmen.repository.enums.EBookType;

import java.util.Arrays;
import java.util.List;

/*
  1- turu novel olan kitapların listesi;
  2-ismi a ile başayan yazarların kitaplarını getirelim;


 */
public class MainHql {

    public static void main(String[] args) {

        BookController bookController=new BookController();
        BookRepository bookRepository=new BookRepository()
                ;
        //bookController.getBooksByType(EBookType.NOVEL).forEach(System.out::println);
 //   bookRepository.getBooksByType().forEach(System.out::println);
   // bookRepository.getBooksWithAuthorNameStartWith("A").forEach(System.out::println);
  //  bookRepository.getBooksByTypeWithCriteria(EBookType.NOVEL).forEach(System.out::println);
//    bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);

//        System.out.println(bookRepository.findByTitle("Yabancı"));

        BorrowRepository borrowRepository=new BorrowRepository();
//        System.out.println(borrowRepository.findByUserId(1L));

//        borrowRepository.findByBookId(3L).forEach(System.out::println);

       List<Object[]> list= bookRepository.getBooksCountByType();
        for (Object[] array:list ) {
            System.out.println(Arrays.toString(array));
        }
    }


}
