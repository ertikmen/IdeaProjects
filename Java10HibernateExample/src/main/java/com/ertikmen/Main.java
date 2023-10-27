package com.ertikmen;

import com.ertikmen.repository.entity.User;
import com.ertikmen.repository.enums.EGender;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        User user=User.builder()
                .name("Mustafa")
                .username("musty")
                .password("123")
                .gender(EGender.MAN)
                .age(25)
                .build();

        User user2=User.builder()
                .name("Osman")
                .username("osmn")
                .password("1258569")
                .gender(EGender.MAN)
                .age(25)
                .build();

        Session session=null;
        Transaction transaction=null;


        try {
            session= HibernateUtility.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.save(user);
            session.save(user2);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }


    }


}
