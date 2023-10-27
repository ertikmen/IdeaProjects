package com.ertikmen.repository;

import com.ertikmen.repository.entity.Author;
import com.ertikmen.repository.entity.Borrow;
import com.ertikmen.repository.entity.Users;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BorrowRepository implements ICrud<Borrow> {
    Session session;
    Transaction transaction;
    @Override
    public Borrow save(Borrow borrow) {
        try {
            session= HibernateUtility.getSESSION_FACTORY().openSession();
            transaction=session.beginTransaction();
            System.out.println("Oturum acıldı...");
            session.save(borrow);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
            session.close();
        }
        return borrow;
    }

    @Override
    public Borrow update(Borrow borrow) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Borrow> findAll() {
        return null;
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return Optional.empty();
    }

    public List<Borrow> findByUserId(Long userId){
        String hql="select b from Borrow b where b.users.id=:x";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Borrow> typedQuery=session.createQuery(hql, Borrow.class);
        typedQuery.setParameter("x",userId);
        List<Borrow> list=typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Users> findByBookId(Long bookId){
        String hql="select b.users from Borrow as b where b.book.id=:x";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Users> typedQuery= session.createQuery(hql, Users.class);
        typedQuery.setParameter("x",bookId);
        List<Users> list=typedQuery.getResultList();
        session.close();
        return list;
    }
}
