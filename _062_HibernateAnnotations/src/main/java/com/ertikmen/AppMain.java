package com.ertikmen;

import com.ertikmen.model.Customer;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

public class AppMain {
    public static void main(String[] args) {
        Customer customer1=new Customer();
        customer1.setFirsname("Engin");
        customer1.setLastname("Ertikmen");
        customer1.setAddress("İzmir");
        customer1.setCreationDate(new Date());
        Customer customer2=new Customer();
        customer2.setFirsname("Osman");
        customer2.setLastname("George");
        customer2.setAddress("Yozgat");
        customer2.setCreationDate(new Date());

        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try{

            transaction=session.beginTransaction();
                session.save(customer1);
                session.save(customer2);
            transaction.commit();

        }catch (HibernateException e){
            System.out.println("Hata: "+e);
        }
    }
}