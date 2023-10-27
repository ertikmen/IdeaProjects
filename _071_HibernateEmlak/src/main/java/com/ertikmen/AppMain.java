package com.ertikmen;


import com.ertikmen.dao.AgentDao;
import com.ertikmen.dao.BuyerDao;
import com.ertikmen.dao.PropertyDao;
import com.ertikmen.dao.SellerDao;
import com.ertikmen.model.Agent;
import com.ertikmen.model.Buyer;
import com.ertikmen.model.Property;
import com.ertikmen.model.Seller;

import java.math.BigDecimal;

public class AppMain {
    public static void main(String[] args) {

        AgentDao agentDao=new AgentDao();
        BuyerDao buyerDao=new BuyerDao();
        PropertyDao propertyDao=new PropertyDao();
        SellerDao sellerDao=new SellerDao();

        Agent agent1=new Agent();
        agent1.setAgentName("Lolo Emlak");
        agent1.setPhone("123456789");
        agent1.setEmail("lolo@gmail.com");
        agent1.setOfficeAddress("Kadıköy");

        Agent agent2=new Agent();
        agent2.setAgentName("Abc Emlak");
        agent2.setPhone("987654321");
        agent2.setEmail("abc@gmail.com");
        agent2.setOfficeAddress("Ataşehir");

        agentDao.saveOrdUpdateAgent(agent1);
        agentDao.saveOrdUpdateAgent(agent2);

        Buyer buyer1=new Buyer();
        buyer1.setFirstName("Engin");
        buyer1.setLastName("Ertikmen");
        buyer1.setPhone("123584758");
        buyer1.setEmail("engin@gmail.com");

        Buyer buyer2=new Buyer();
        buyer1.setFirstName("Osman");
        buyer1.setLastName("George");
        buyer1.setPhone("85471582");
        buyer1.setEmail("osman@gmail.com");

        buyerDao.saveOrdUpdateBuyer(buyer1);
        buyerDao.saveOrdUpdateBuyer(buyer2);

        Seller seller1=new Seller();
        seller1.setFirstName("Yılmaz");
        seller1.setLastName("Morgül");
        seller1.setPhone("85471528");
        seller1.setEmail("yilmaz@gmail.com");

        Seller seller2=new Seller();
        seller2.setFirstName("Tansu");
        seller2.setLastName("Çiller");
        seller2.setPhone("847125635");
        seller2.setEmail("tansu@gmail.com");

        sellerDao.saveOrdUpdateSeller(seller1);
        sellerDao.saveOrdUpdateSeller(seller2);

        Property property1=new Property();
        property1.setTittle("Dublex");
        property1.setArea(300.55F);
        property1.setBedrooms(6);
        property1.setBathrooms(2);
        property1.setPrice(BigDecimal.valueOf(1_000_000.25));
        property1.setDescription("Doktordan temiz");
        property1.getBuyers().add(buyer1);
        property1.setSeller(seller1);

        Property property2=new Property();
        property2.setTittle("Triplex");
        property2.setArea(200.55F);
        property2.setBedrooms(4);
        property2.setBathrooms(2);
        property2.setPrice(BigDecimal.valueOf(800_000.25));
        property2.setDescription("Memurdan temiz");
        property2.getBuyers().add(buyer2);
        property1.setSeller(seller2);

        propertyDao.saveOrdUpdateProperty(property1);
        propertyDao.saveOrdUpdateProperty(property2);

        System.out.println("Agent");
        agentDao.getAllAgents().forEach(System.out::println);

        System.out.println("\nBuyers");
        buyerDao.getAllBuyers().forEach(System.out::println);

        System.out.println("\nSellers");
        sellerDao.getAllSellers().forEach(System.out::println);

        System.out.println("\nProperties");
        propertyDao.getAllProperties().forEach(System.out::println);

    }
}