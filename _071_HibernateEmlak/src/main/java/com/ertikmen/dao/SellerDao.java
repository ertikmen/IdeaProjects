package com.ertikmen.dao;

import com.ertikmen.model.Seller;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SellerDao {


    Transaction transaction=null;
    Session session=null;

    public void saveOrdUpdateSeller(Seller seller){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(seller);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public Seller getSellerById(Long id){

        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.get(Seller.class,id);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Seller> getAllSellers(){
        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Seller", Seller.class).list();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteSellerById(Long id){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            Seller seller=session.get(Seller.class,id);
            if(seller!=null) session.delete(seller);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }
}
