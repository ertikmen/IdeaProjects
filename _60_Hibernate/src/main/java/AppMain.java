import model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Date;

public class AppMain {

    public static void main(String[] args) {

        Customer customer=new Customer();
        customer.setFirstname("Burak");
        customer.setLastname("Delice");
        customer.setAddress("Ankara");
        customer.setCreationDate(new Date());
        Customer customer2=new Customer("Engin","Ertikmen","Adana",new Date());

        Session session= HibernateUtil.getSessionFactory().openSession();

        Transaction transaction=null;

        try{

            transaction=session.beginTransaction();
                    session.save(customer);
                    session.save(customer2);
            transaction.commit();

        }catch(HibernateException e){
            transaction.rollback();
            System.out.println("Hata: "+e);
        }
        finally {
            session.close();
        }

    }

}
