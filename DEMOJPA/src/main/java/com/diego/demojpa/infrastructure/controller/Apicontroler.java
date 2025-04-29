package com.diego.demojpa.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.demojpa.application.service.PersonService;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.Rol;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Apicontroler {
    // /api/users
    // /api/listar
    // /api/buscar

    private final PersonService personService;

    public Apicontroler(PersonService personService) {
        this.personService = personService;
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

    @GetMapping("/roles")
    public List<Rol> findAllRoles(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "0") String value
        ) {
        // /api/users?filter=name&value=Diego
        // /api/users?filter=language&value=Java
        List<Rol> result = personService.findAllRolesByFilter(filter, value);
 
        return result;
    }
}
