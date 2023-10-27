package com.ertikmen;

import com.ertikmen.model.Customer;
import com.ertikmen.model.CustomerDetail;
import com.ertikmen.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AppMain {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setTitle("MSc.Computer Engineer");
        customer.setFirstname("Burak");
        customer.setLastname("Bey");

        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setAddress("Ankara");
        customerDetail.setPhone("111");
        customerDetail.setCreationDate(new Date());
        customerDetail.setCustomer(customer);
        customer.setCustomerDetail(customerDetail);

        Customer customer2 = new Customer("Dr.", "Engin", "Bey");

        CustomerDetail customerDetail2 = new CustomerDetail("Adana", "222", new Date());
        customerDetail2.setCustomer(customer2);
        customer2.setCustomerDetail(customerDetail2);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
//            session.save(customer);
//            session.save(customer2);
//            System.out.println("==========select==============");
            Query query1=session.createQuery("from Customer order by customerId");
//            List<Customer> customerList=query1.list();

//            customerList.forEach(System.out::println);
//            for ( Customer cust: customerList) {
//                System.out.println(cust.getCustomerId()+" "+cust.getTitle()+" "+cust.getFirstname()+" "+cust.getLastname());
//            }
//            System.out.println("======== idye göre======================");
//            Query query2=session.createQuery("from Customer where id=:id");
//            query2.setLong("id",2);
//            Customer cust2= (Customer) query2.uniqueResult();
//            System.out.println(cust2);

//            System.out.println("======================= update ======================");
//
//            query1=session.createQuery("update Customer set firstname=:first_name,lastname=:last_name,title=:title" +
//                    " where id=:id");
//            query1.setParameter("title","Doc.");
//            query1.setParameter("first_name","Aminenur");
//            query1.setParameter("last_name","Göynük");
//
//            query1.setLong("id",5);
//
//            int result=query1.executeUpdate();
//            System.out.println(result);
//            System.out.println("=============Update Sorgu sonucu===========");
//
//            query1=session.createQuery("from Customer order by id");
//            List<Customer> customerList3=query1.list();
//            for ( Customer cust3: customerList3) {
//                System.out.println(cust3.getCustomerId()+" "+cust3.getTitle()+" "+cust3.getFirstname()+" "+cust3.getLastname());
//            }


//            System.out.println("================delete=============");
//
//            query1=session.createQuery("delete from Customer where id=:id");
//            query1.setLong("id",6);
//            int result2=query1.executeUpdate();
//            System.out.println(result2);
//            System.out.println("=============Delete Sonrası===========");
//
//            query1=session.createQuery("from Customer order by id");
//            List<Customer> customerList4=query1.list();
//            for ( Customer cust4: customerList4) {
//                System.out.println(cust4.getCustomerId()+" "+cust4.getTitle()+" "+cust4.getFirstname()+" "+cust4.getLastname());
//            }

            System.out.println("==========================AVG SUM MIN MAX COUNT===========================");
            query1=session.createQuery("select count(*) from Customer ");

            Long result= (Long) query1.uniqueResult();

            System.out.println("Müşteri sayısı: "+result);

            System.out.println("==========================Join===========================");

            query1=session.createQuery("select c.customerId,c.firstname,cd.address from Customer c left join CustomerDetail cd on c.customerId=cd.customerId");

            List<Object[]> mylist=query1.list();
            for (Object[] arr: mylist) {
               System.out.println(Arrays.toString(arr));
            }


            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Hata: " + e);
        } finally {
            session.close();
        }

    }
}