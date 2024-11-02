package com.dev.microservice_bank.repositories;

import com.dev.microservice_bank.entities.Compte;
import com.dev.microservice_bank.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {

    @RestResource(path = "/byType")
    public List<Compte> findByType(@Param("t") TypeCompte type);// /api/comptes/search/byType?t=COURANT

    // /api/comptes/search/findByType?type=EPARGNE
}
