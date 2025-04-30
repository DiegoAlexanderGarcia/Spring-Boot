package com.diego.demojpa.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.demojpa.application.service.PersonService;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.project;
import com.diego.demojpa.infrastructure.repositiry.ProyectService;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Apicontroler {
    // /api/users
    // /api/listar
    // /api/buscar

    private final PersonService personService;
    private final ProyectService proyectService;

    public Apicontroler(PersonService personService, ProyectService proyectService) {
        this.personService = personService;
        this.proyectService = proyectService;

    }

    @GetMapping("/users")
    public List<Person> findAllUsers(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "0") String value
        ) {
        // /api/users?filter=name&value=Diego
        // /api/users?filter=language&value=Java
        List<Person> result = personService.findAllUsersByFilter(filter, value);
 
        return result;
    }

    @PostMapping("/roles")
    public Map<String, String> newRoles(){
        return Map.of("name", "Rol", "description", "Rol de usuario", "id", "0");
    }


    @GetMapping("/projects")
    public List<project> findAllProjects(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "0") String value
        ) {
        List<project> result = proyectService.findAllProjects();
 
        return result;
    }

}