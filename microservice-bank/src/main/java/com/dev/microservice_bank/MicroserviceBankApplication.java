package com.dev.microservice_bank;

import com.dev.microservice_bank.entities.Client;
import com.dev.microservice_bank.entities.Compte;
import com.dev.microservice_bank.entities.TypeCompte;
import com.dev.microservice_bank.repositories.ClientRepository;
import com.dev.microservice_bank.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MicroserviceBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBankApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration restConfiguration,
                            ClientRepository clientRepository){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);
            Client client1 = clientRepository.save(new Client(null, "Client1", null));
            Client client2 = clientRepository.save(new Client(null, "Client2",null));
            Client client3 = clientRepository.save(new Client(null, "Client3",null));

            compteRepository.save(new Compte(null,Math.random()*700,new Date(), TypeCompte.EPARGNE,client1));
            compteRepository.save(new Compte(null,Math.random()*700,new Date(), TypeCompte.EPARGNE,client2));
            compteRepository.save(new Compte(null,Math.random()*700,new Date(), TypeCompte.COURANT, client3));
            compteRepository.findAll().forEach(
                    c -> {
                        System.out.println(c.getSolde());
                    }
            );
        };
    }
}
