package com.dev.microservice_bank.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2 {
    public  double getSolde();
    public TypeCompte getType();
}
