package com.dev.microservice_bank;

import com.dev.microservice_bank.web.CompteRestJaxRSAPI;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

   // @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet= new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class);
        return  jerseyServlet;
    }


}
