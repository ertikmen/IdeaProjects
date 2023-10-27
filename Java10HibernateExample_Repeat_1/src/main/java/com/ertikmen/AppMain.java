package com.ertikmen;

import com.ertikmen.repository.entity.Address;
import com.ertikmen.repository.entity.Name;
import com.ertikmen.repository.entity.User;
import com.ertikmen.repository.enums.EAdressType;
import com.ertikmen.repository.enums.EGender;
import com.ertikmen.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMain {

    public static void main(String[] args) {

        List<String> interest1= List.of("Müzik","Dans");
        List<String> interest2= List.of("Sinema","Tiyatro");
        Map<EAdressType, Address> map1=new HashMap<>();
        map1.put(EAdressType.HOME,Address.builder().city("Ankara").country("Türkiye").build());
        map1.put(EAdressType.WORK,Address.builder().city("İstanbul").country("Türkiye").build());

        Map<EAdressType, Address> map2=new HashMap<>();
        map2.put(EAdressType.HOME,Address.builder().city("İzmir").country("Türkiye").build());
        map2.put(EAdressType.WORK,new Address("Antalya","Türkiye"));

        User user1=User.builder()
                .name(Name.builder().firstName("Osman").middleName("Brain").lastName("George").build())
                .username("osmn")
                .password("123456987")
                .age(85)
                .gender(EGender.MAN)
                .interests(interest1)
                .adresses(map1)
                .build();

        User user2=User.builder()
                .name(Name.builder().firstName("Ayşe").middleName("Sevim").lastName("Bayram").build())
                .username("ays")
                .password("85471258")
                .age(95)
                .gender(EGender.WOMAN)
                .interests(interest2)
                .adresses(map2)
                .build();

        Session session=null;
        Transaction transaction=null;

        try {
            session= HibernateUtility.getSessionFactory().openSession();
            transaction=session.beginTransaction();
                session.save(user1);
                session.save(user2);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }


    }
}
