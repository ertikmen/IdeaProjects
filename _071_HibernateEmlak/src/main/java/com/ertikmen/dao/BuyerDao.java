package com.ertikmen.dao;

import com.ertikmen.model.Buyer;
import com.ertikmen.model.Buyer;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BuyerDao {

    Transaction transaction=null;
    Session session=null;

    public void saveOrdUpdateBuyer(Buyer buyer){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(buyer);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public Buyer getBuyerById(Long id){

        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.get(Buyer.class,id);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Buyer> getAllBuyers(){
        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Buyer", Buyer.class).list();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteBuyerById(Long id){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            Buyer buyer=session.get(Buyer.class,id);
            if(buyer!=null) session.delete(buyer);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }
}
