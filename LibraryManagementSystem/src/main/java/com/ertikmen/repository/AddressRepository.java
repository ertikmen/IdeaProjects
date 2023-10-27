package com.ertikmen.repository;

import com.ertikmen.repository.entity.Address;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AddressRepository implements ICrud<Address>{

    Session session;
    Transaction transaction;


    @Override
    public Address save(Address address) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            System.out.println("Oturum açıldı....");
            session.save(address);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
            session.close();
        }

        return address;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void deleteById(Long Id) {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Optional<Address> findById(Long Id) {
        return Optional.empty();
    }
}
