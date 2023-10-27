package com.ertikmen.utility;

import com.ertikmen.controller.AuthorController;
import com.ertikmen.controller.BookController;
import com.ertikmen.controller.BorrowController;
import com.ertikmen.controller.UserController;
import com.ertikmen.repository.entity.*;
import com.ertikmen.repository.enums.EBookType;
import com.ertikmen.repository.enums.EStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CreateData {
    public  static  void createData(){

        Author author= Author.builder().firstName("KEMAL").lastName("TAHIR").build();
       
 BookController bookController=new BookController();
        Book book=Book.builder().
                title("Hür Sehrin insanları").bookType(EBookType.HISTORY).author(author).build();
        Book book2=Book.builder().
                title("Esir Sehrin insanları").bookType(EBookType.HISTORY).author(author).build();
        Book book3=Book.builder().
                title("Yorgun savascı").bookType(EBookType.HISTORY).author(author).build();

        bookController.save(book);
        bookController.save(book2);
        bookController.save(book3);

        Author author1= Author.builder().firstName("Albert").lastName("Camus").build();
        Book book4= Book.builder().title("Yabancı").bookType(EBookType.NOVEL).author(author1).build();
        Book book5= Book.builder().title("Mutlu ölüm").bookType(EBookType.NOVEL).author(author1).build();
        Book book6= Book.builder().title("Sisifos Söyleni").bookType(EBookType.NOVEL).author(author1).build();

        bookController.save(book4);
        bookController.save(book5);
        bookController.save(book6);
     
//
        Author author3= Author.builder().firstName(" Sait Faik").lastName("Abasıyanık").build();
        Book book7= Book.builder().title("Son Kuşlar").bookType(EBookType.STORY).author(author3).build();
        Book book8= Book.builder().title("Yabancı").bookType(EBookType.STORY).author(author3).build();
        bookController.save(book7);
        bookController.save(book8);

        Author author4= Author.builder().firstName("Nikolay").lastName("Gogol").build();
        Book book9= Book.builder().title("Ölü Canlar").bookType(EBookType.NOVEL).author(author3).build();
        bookController.save(book9);
		
		
        Author author5= Author.builder().firstName("Erich").lastName("From").build();

        Book book10= Book.builder().title("Özgürlükten Kaçış").bookType(EBookType.NOVEL).author(author5).build();
        Book book11= Book.builder().title("Sevme Sanatı").bookType(EBookType.NOVEL).author(author5).build();
        bookController.save(book10);
        bookController.save(book11);
        //// user olusturma
        Address address1=Address.builder().country("Turkiye").city("Ankara").build();
        Address address2=Address.builder().country("Türkiye").city("Balıkesir").build();
        Address address3=Address.builder().country("Türkiye").city("Konya").build();
        Address address4=Address.builder().country("Türkiye").city("İzmir").build();
        Address address5=Address.builder().country("Türkiye").city("Amasya").build();
        Address address6=Address.builder().country("Türkiye").city("Erzincan").build();

        UserInformation userInformation=UserInformation.builder().firstName("Mustafa")
                .lastName("Ozturk")

                .phoneNumber("5555-555-55-5")
                .about("hakkımda........")
                .address(Set.of(address1 ,address2))
                .build();

        UserInformation userInformation2=UserInformation.builder().firstName("Tuba")
                .lastName("Ozturk")

                .phoneNumber("5555-555-55-5")
                .about("hakkımda........")
                .address(Set.of(address1 ,address3,address4))
                .build();
        UserInformation userInformation3=UserInformation.builder().firstName("Derya")
                .lastName("Ozturk")

                .phoneNumber("5555-555-55-5")
                .about("hakkımda........")
                .address(Set.of(address5 ,address6))
                .build();

        Users user= Users.builder().username("musty").password("123")
                .userInformation(userInformation)
                .build();
        Users user2=Users.builder().username("tuba").password("123").userInformation(userInformation2).build();
        Users user3=Users.builder().username("derya").password("123").userInformation(userInformation3).build();
        //
        UserController userController=new UserController();
        userController.save(user);
        userController.save(user2);
        userController.save(user3);



        Borrow borrow1= Borrow.builder()
                .book(book)
                .users(user)
                .period(5)
                .borrowDate(LocalDate.now().minusDays(8))
                .build();
        /// once 5 gunluk kiralama yaptık
        book.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book);
        // daha sonra 5 gun sonra kiralanan kitabın geri iade oldugu bir senaryo olusturduk
        book.setStatus(EStatus.AVAILABLE);
        bookController.update(book);
        //daha sonra aynı kitabı başka bir kullanıcı tekrardan kiraldı
        Borrow borrow2= Borrow.builder()
                .book(book)
                .users(user2)
                .period(5)
                .borrowDate(LocalDate.now().minusDays(2))
                .build();
        book.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book);
        Borrow borrow3= Borrow.builder()
                .book(book6)
                .users(user)
                .period(10)
                .build();
        book6.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book6);
        Borrow borrow4= Borrow.builder()
                .book(book5)
                .users(user)
                .period(10)
                .build();
        book5.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book5);
        BorrowController borrowController=new BorrowController();
        borrowController.save(borrow1);
        borrowController.save(borrow2);
        borrowController.save(borrow3);
        borrowController.save(borrow4);

    }


       public static void main(String[] args) {
              createData();
       }
}
