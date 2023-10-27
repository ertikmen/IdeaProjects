package com.bilgeadam;

import com.bilgeadam.repository.entity.Address;
import com.bilgeadam.repository.entity.EAddressType;
import com.bilgeadam.repository.entity.Name;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.repository.enums.EGender;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> interest1=List.of("Müzik","Dans");
        List<String> interest2=List.of("Sinema","Tiyatro");
        // 1.Map
        Map<EAddressType, Address> map1=new HashMap<>();
        map1.put(EAddressType.HOME, Address.builder().city("Ankara").country("Türkiye").build());
        map1.put(EAddressType.WORK, Address.builder().city("İstanbul").country("Türkiye").build());
      //2.map
        Map<EAddressType, Address> map2=new HashMap<>();
        map2.put(EAddressType.HOME, Address.builder().city("İzmir").country("Türkiye").build());
        map2.put(EAddressType.WORK, new Address("Antalya","Türkiye"));

        User user= User.builder()
                .name(Name.builder().firstName("Mustafa").lastName("Ozturk").build())
                .username("musty")
                .password("12345")
                .gender(EGender.MAN)
                .interests(interest1)
                .addresses(map1)
                .age(25)
                .build();
        User user2= User.builder()
                .name(Name.builder().firstName("Ece").middleName("Beren").lastName("Erenoğlu").build())
                .username("ece")
                .password("12345646646546")
                .interests(interest2)
                .addresses(map2)
                .age(18)
                .build();

        Session session=null;
        Transaction transaction=null;
        try {
            session=HibernateUtility.getSessionFactory().openSession();
            transaction=session.beginTransaction();
             session.save(user);
             session.save(user2);

            System.out.println("user: "+user);

            System.out.println(user2.getInterests().size());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();;
        }finally {
            session.close();
        }


    }
}