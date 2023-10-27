package com.ertikmen.repository;

import com.ertikmen.repository.entity.Post;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PostRepository implements ICrud<Post> {

    Session session;
    Transaction transaction;


    @Override
    public Post save(Post post) {

        try {
            session= HibernateUtility.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            session.save(post);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Kayıt başarısız..");

        }finally {
            System.out.println("Oturum kapanıyor..");
            session.close();
        }

        return post;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long Id) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(Long Id) {
        return Optional.empty();
    }
}
