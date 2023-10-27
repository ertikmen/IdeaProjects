package com.ertikmen;

import com.ertikmen.model.Customer;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;


public class AppMain {

    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setFirstname("Burak");
        customer.setLastname("Delice");
        customer.setAddress("Ankara");
        customer.setCreationDate(new Date());

        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try{

            transaction=session.beginTransaction();
                    session.save(customer);
                    session.update(customer);
            transaction.commit();

        }catch (HibernateException e){
            transaction.rollback();
            System.out.println("Hata: "+e);
        }

    }

}
