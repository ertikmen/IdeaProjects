package com.ertikmen.repository;

import com.ertikmen.model.Kisi;
import com.ertikmen.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KisiRepository {

    public void saveOrdUpdateKisi(Kisi kisi) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(kisi);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Kisi getKisiById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Kisi.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Kisi> getAllKisi() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Kisi", Kisi.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteKisiById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Kisi kisi = session.get(Kisi.class, id);
            if (kisi != null) {
                session.delete(id);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Kisi kisiOlustur(Kisi kisi) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(kisi);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return kisi;
    }


    public Kisi kisiAraById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("KİSİ DURUMU: " +session.get(Kisi.class, id));
            return session.get(Kisi.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
