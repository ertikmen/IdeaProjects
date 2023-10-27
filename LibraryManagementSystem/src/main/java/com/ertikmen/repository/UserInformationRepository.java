package com.ertikmen.repository;


import com.ertikmen.repository.entity.UserInformation;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserInformationRepository implements ICrud<UserInformation> {

    Session session;
    Transaction transaction;


    @Override
    public UserInformation save(UserInformation userInformation) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            System.out.println("Oturum açıldı....");
            session.save(userInformation);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
            session.close();
        }

        return userInformation;

    }

    @Override
    public UserInformation update(UserInformation userInformation) {
        return null;
    }

    @Override
    public void deleteById(Long Id) {

    }

    @Override
    public List<UserInformation> findAll() {
        return null;
    }

    @Override
    public Optional<UserInformation> findById(Long Id) {
        return Optional.empty();
    }
}
