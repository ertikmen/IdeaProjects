package com.ertikmen.dao;

import com.ertikmen.model.Agent;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AgentDao {

    Transaction transaction=null;
    Session session=null;

    public void saveOrdUpdateAgent(Agent agent){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(agent);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public Agent getAgentById(Long id){

        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.get(Agent.class,id);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Agent> getAllAgents(){
        try {

            session= HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Agent", Agent.class).list();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteAgentById(Long id){

        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            Agent agent=session.get(Agent.class,id);
            if(agent!=null) session.delete(agent);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }

}
