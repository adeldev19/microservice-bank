package com.dev.microservice_bank.web;

import com.dev.microservice_bank.entities.Compte;
import com.dev.microservice_bank.repositories.CompteRepository;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController
*/
@RequestMapping("/bank")
public class CompteRestControllerAPI {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Compte> consulterListCompte(){
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{id}")
    public Compte getOne(@PathVariable(value = "id") Long id){
        return compteRepository.findById(id).get();
    }

    @PostMapping(path = "/comptes")
    public Compte save (@RequestBody Compte compte){
        return compteRepository.save(compte);
    }
    @PutMapping(path = "/comptes/{id}")
    public Compte update(@RequestBody Compte compte, @PathVariable("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/comptes/{id}")
    public void delete(@PathVariable("id") Long id){
         compteRepository.deleteById(id);
    }
}
