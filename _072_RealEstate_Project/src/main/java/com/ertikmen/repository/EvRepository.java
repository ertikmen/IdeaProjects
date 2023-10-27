package com.ertikmen.repository;

import com.ertikmen.model.Ev;
import com.ertikmen.utility.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class EvRepository {

    public List<Ev> kiradaOlanEvler(){
        String hql="SELECT e FROM Ev e where e.durum='KIRADA'";
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Ev> typedQuery =session.createQuery(hql, Ev.class);
        return typedQuery.getResultList();
    }

}
