package com.ertikmen.repository;

import com.ertikmen.model.Arac;
import com.ertikmen.model.Kiralama;
import com.ertikmen.model.Kisi;
import com.ertikmen.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KiralamaRepository {

    public void kiradakiAraclar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           session.createQuery("from Arac ", Kisi.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
