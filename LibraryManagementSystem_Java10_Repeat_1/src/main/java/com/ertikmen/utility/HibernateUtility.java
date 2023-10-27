package com.ertikmen.utility;

import com.ertikmen.repository.entity.*;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    @Getter
    private static final SessionFactory SESSION_FACTORY=createSessionFactory();

    private static SessionFactory createSessionFactory() {

        try {
            Configuration configuration=new Configuration();
            configuration.addAnnotatedClass(Users.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(UserInformation.class);
            configuration.addAnnotatedClass(Borrow.class);
            SessionFactory sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
           return  sessionFactory;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }


    }

}
