package com.ertikmen.config;


import com.ertikmen.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContexJavaConfig {


    @Bean(name="aService")
    public SelectService aService(){
        return new AService();
    }

    @Bean(name="bService")
    public SelectService bService(){
        return new BService();
    }

    @Bean(name="cService")
    public SelectService cService(){
        return new CService();
    }

    @Bean(name="messageProcessor")
    public MessageProccessor messageProccessor(){
        return new MessageProccessorImpl(aService());
    }

}
