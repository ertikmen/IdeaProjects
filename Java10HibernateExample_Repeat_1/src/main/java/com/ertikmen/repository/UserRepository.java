package com.ertikmen.repository;

import com.ertikmen.repository.entity.User;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserRepository implements ICrud<User>{

    Session session;
    Transaction transaction;

    @Override
    public User save(User user) {

            try {
                session= HibernateUtility.getSessionFactory().openSession();
                transaction= session.beginTransaction();
                session.save(user);
                transaction.commit();
                System.out.println("Kayıt başarılı...");

            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
                System.out.println("Kayıt başarısız...");
            }finally {
                System.out.println("Oturum kapanıyor...");
                session.close();
            }

        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }


    @Override
    public void deleteById(Long Id) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long Id) {
        return Optional.empty();
    }
}
