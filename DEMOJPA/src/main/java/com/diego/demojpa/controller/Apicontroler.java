package com.diego.demojpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.demojpa.domain.Person;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Apicontroler {
    // /api/users
    // /api/listar
    // /api/buscar

    @GetMapping("/users")
    public List<Person> findAll() {

        List<Person> result = List.of(new Person(1L, "Diego", "Garcia", "Spring Boot"));

        return result;
    }
}
