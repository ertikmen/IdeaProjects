package com.ertikmen.repository;

import com.ertikmen.repository.entity.Name;
import com.ertikmen.repository.entity.User;
import com.ertikmen.utility.HibernateUtility;
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
        String hql="select u from User u where u.id=:id";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery= session.createQuery(hql,User.class);
        typedQuery.setParameter("id",id);
        User user=null;
        try{
            user=typedQuery.getSingleResult();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findById2(Long id) {
        session=HibernateUtility.getSessionFactory().openSession();

        User user=session.find(User.class,id);
        if (user==null) System.out.println("Kullanıcı bulunamadı");
        return Optional.ofNullable(user);
    }

   public List<Name> findAllName(){
        String hql="select u.name from User u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Name> typedQuery=session.createQuery(hql,Name.class);
        List<Name> list=typedQuery.getResultList();
        return list;
   }
    public List<String> findAllFirstName(){
        String hql="select u.name.firstName from User u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<String> typedQuery=session.createQuery(hql,String.class);
        List<String> list=typedQuery.getResultList();
        return list;
    }


    public Optional<User> findByUsername(String username) {

        String hql="select u from User u where u.username=:myusername";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery=session.createQuery(hql,User.class);
        typedQuery.setParameter("myusername",username);
        User user1=typedQuery.getSingleResult();
        System.out.println(user1);
        return Optional.ofNullable(user1);
    }

    public Optional<User> mostPostingUser(){
        String hql="select u from User u where postCount=(select max(postCount) from User)";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery=session.createQuery(hql,User.class);
        User user=null;
        List<User> list=typedQuery.getResultList();
        if (!list.isEmpty())
        user=list.get(0);
         return Optional.ofNullable(user);
    }



}
