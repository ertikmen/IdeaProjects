package com.ertikmen;

import com.ertikmen.model.Customer;
import com.ertikmen.model.Orders;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppMain {
    public static void main(String[] args) {

        Customer customer1=new Customer();
        customer1.setTitle("Dr.");
        customer1.setFirstName("Caner");
        customer1.setLastName("Öksüz");

        Orders orders1=new Orders("Kayısı",254.23F,new Date());
        Orders orders2=new Orders("Elma",122.38F,new Date());
        Orders orders3=new Orders("Armut",395.85F,new Date());

        customer1.getOrder().add(orders1);
        customer1.getOrder().add(orders2);
        customer1.getOrder().add(orders3);

        orders1.setCustomer(customer1);
        orders2.setCustomer(customer1);
        orders3.setCustomer(customer1);


        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try{
            transaction=session.beginTransaction();
            session.save(customer1);
            session.save(orders1);
            session.save(orders2);
            session.save(orders3);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

    }
}
