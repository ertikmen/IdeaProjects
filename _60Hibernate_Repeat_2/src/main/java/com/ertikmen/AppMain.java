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
        Customer customer=new Customer();
        customer.setFirsname("Engin");
        customer.setLastname("Ertikmen");
        customer.setAddress("İzmir");
        customer.setCreationDate(new Date());

        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try{

            transaction=session.beginTransaction();
                    session.save(customer);
            transaction.commit();

        }catch (HibernateException e){
            System.out.println("Hata: "+e);
        }
    }
}
