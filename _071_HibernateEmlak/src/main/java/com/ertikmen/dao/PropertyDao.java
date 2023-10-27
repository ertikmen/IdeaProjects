package com.ertikmen.dao;


import com.ertikmen.model.Property;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PropertyDao {
    Transaction transaction=null;
    Session session=null;

    public void saveOrdUpdateProperty(Property property){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(property);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public Property getPropertyById(Long id){

        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.get(Property.class,id);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Property> getAllProperties(){
        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Property", Property.class).list();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void deletePropertyById(Long id){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            Property property=session.get(Property.class,id);
            if(property!=null) session.delete(property);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }
}
