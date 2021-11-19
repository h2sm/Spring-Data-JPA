package com.h2sm.springdatajpa.configs;

import com.h2sm.springdatajpa.entity.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConf {
    @Bean
    public Client getCli(){
        return new Client();
    }
}
