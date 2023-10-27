package com.ertikmen.repository;

import com.ertikmen.repository.entity.Address;
import com.ertikmen.repository.entity.Book;
import com.ertikmen.repository.entity.Users;
import com.ertikmen.repository.enums.EBookType;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class BookRepository implements ICrud<Book> {
    Session session;
    Transaction transaction;
    @Override
    public Book save(Book book) {
        try {
            session= HibernateUtility.getSESSION_FACTORY().openSession();
            transaction=session.beginTransaction();
            System.out.println("Oturum acıldı...");
            session.save(book);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
            session.close();
        }
        return book;
    }

    @Override
    public Book update(Book book) {
        try {
            session=HibernateUtility.getSESSION_FACTORY().openSession();
            transaction= session.beginTransaction();
            System.out.println("Oturum acıldı...");
            session.update(book);
            transaction.commit();
            System.out.println("Guncelleme başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
            session.close();
        }
        return book;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    public List<Book> getBooksByType(EBookType type){
        String hql="select b from Book as b where b.bookType=:x";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createQuery(hql, Book.class);
        typedQuery.setParameter("x",type);
        return typedQuery.getResultList();
    }
    public List<Book> getBooksByType(){
        String hql="select b from Book as b where b.bookType='NOVEL'";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createQuery(hql, Book.class);
        return typedQuery.getResultList();
    }

    public List<Book> getBooksByTypeWithCriteria(EBookType type){
        EntityManager entityManager=HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder =entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery=criteriaBuilder.createQuery(Book.class);
        Root<Book> root=criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("bookType"),type));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public List<Book> getBooksByTypeNamedQuery(EBookType type){
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createNamedQuery("findByBookType", Book.class);
        typedQuery.setParameter("myType",type);
        return typedQuery.getResultList();
    }
    public List<Book> getBooksWithAuthorNameStartWith(String value){
        String hql="select b from Book as b  where b.author.firstName like '"+value+"%'";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createQuery(hql, Book.class);
        return typedQuery.getResultList();
    }

    public Optional<Book> findByTitle(String title){
        String hql="select b from Book b where b.title=:x";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createQuery(hql,Book.class);
        typedQuery.setParameter("x",title);
        Book book=null;
        try{
            book=typedQuery.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return Optional.ofNullable(book);
    }

//    public Optional<List<Book>> groupbyType(){
//        String hql="select bookType,count(*) from Book group by bookType";
//        session=HibernateUtility.getSESSION_FACTORY().openSession();
//        TypedQuery<Book> typedQuery=session.createQuery(hql,Book.class);
//        List<Book> list=typedQuery.getResultList();
//        session.close();
//        return Optional.ofNullable(list);
//    }
    public List<Object[]> getBooksCountByType(){
        String hql="select bookType,count(*) from Book group by bookType";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Object[]> typedQuery=session.createQuery(hql,Object[].class);
        List<Object[]> list=typedQuery.getResultList();
        session.close();
        return list;
    }
}
