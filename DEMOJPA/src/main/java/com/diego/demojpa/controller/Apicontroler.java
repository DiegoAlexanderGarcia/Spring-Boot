package com.diego.demojpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.demojpa.domain.Person;
import com.diego.demojpa.repositiry.PersonRepository;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Apicontroler {
    // /api/users
    // /api/listar
    // /api/buscar

    private final PersonRepository personRepository;

    public Apicontroler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/users")
    public List<Person> findAll() {

        List<Person> result = personRepository.findAll();
        //List<Person> result2 = personRepository.findByNameContains("Diego");
        //List<Person> result3 = personRepository.findByLanguageEquals("Java");
        //List<Person> result4 = personRepository.findByLastNameList("Garcia");
        
        return result;
    }
}
