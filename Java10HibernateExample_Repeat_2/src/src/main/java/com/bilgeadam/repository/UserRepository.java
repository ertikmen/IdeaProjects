package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.User;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
/*
    findbyUsername metodunu hql sorgusu olarak yazalım


 */
public class UserRepository implements ICrud<User>{
    Session session;
    Transaction transaction;

    @Override
    public User save(User user) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı...");
            transaction= session.beginTransaction();
           session.save(user);
            transaction.commit();
            System.out.println("Kayıt başarılı....");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Kayıt başarısız!!!!!");
        }finally {
            System.out.println("oturum kapanıyor...");
            session.close();
        }
        return  user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
      //  String sql=" select * from tbl_user";
        String hql=" select u from User as u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery= session.createQuery(hql, User.class);
        List<User> userList=typedQuery.getResultList();
        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    public Optional<User> findByUsername(String username){
        String hql="select u from User as u where u.username=:myusername";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery=session.createQuery(hql, User.class);
        typedQuery.setParameter("myusername",username);
       /* Query query=session.createQuery(hql);
        query.setParameter("myusername",username);
        User user2= (User) query.getSingleResult();
        System.out.println("query==>"+user2);
        System.out.println("typed quert==>"+user1);*/
        // getSingleResult bulamadıgı zaman exception fırlatır ;
        User user=null;
        try {
            user=typedQuery.getSingleResult();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return  Optional.ofNullable(user);
    }

}
