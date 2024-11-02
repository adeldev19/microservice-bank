package com.dev.microservice_bank.entities;

import org.springframework.data.rest.core.config.Projection;

///api/comptes/2?projection=solde
@Projection(name = "solde", types = Compte.class)
public interface CompteProjection1 {
    public  double getSolde();
}
