package com.ertikmen.repository;

import com.ertikmen.model.Arac;
import com.ertikmen.model.Kiralama;
import com.ertikmen.model.Kisi;
import com.ertikmen.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class KiralamaRepository {

    public void kiradakiAraclar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           session.createQuery("from Arac ", Kisi.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Arac> kiralananAraclarByKisiId(Long id){
        String hql="SELECT k.arac FROM Kiralama k where k.kisi.id=:id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Arac> typedQuery =session.createQuery(hql, Arac.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getResultList();
    }


    public Kiralama kiralamaOlustur(Kiralama kiralama) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
                session.save(kiralama);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return kiralama;
    }
}
