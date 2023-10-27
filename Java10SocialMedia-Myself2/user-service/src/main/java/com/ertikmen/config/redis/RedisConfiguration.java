package com.ertikmen.config.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableCaching // ön bellek yönetimi için
@EnableRedisRepositories // database üzerinden işlem yapmak için
public class RedisConfiguration {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;

    @Bean // bununla birlikte uygulama ayağa kalkaerken redise bağlamış oluyoruz.
    public LettuceConnectionFactory redisConnectionFactory(){  // bağlantı yapıyoruz..
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(host,port));
    }


}
