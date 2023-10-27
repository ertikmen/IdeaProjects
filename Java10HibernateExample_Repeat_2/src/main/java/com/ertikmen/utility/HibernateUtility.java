package com.ertikmen.utility;

import com.ertikmen.repository.entity.Post;
import com.ertikmen.repository.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtility {

    private  static  final SessionFactory SESSION_FACTORY=createSessionFactory();

    private static SessionFactory createSessionFactory() {

        try {
            Configuration configuration=new Configuration();
               configuration.addAnnotatedClass(User.class);
               configuration.addAnnotatedClass(Post.class);
            SessionFactory sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        } catch (HibernateException e) {
            e.printStackTrace();
            return  null;
        }

    }

    public static  SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}
