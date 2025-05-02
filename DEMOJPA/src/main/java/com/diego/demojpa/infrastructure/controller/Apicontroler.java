package com.diego.demojpa.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diego.demojpa.application.service.PersonService;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.Rol;
import com.diego.demojpa.domain.RoleRequest;
import com.diego.demojpa.domain.project;
import com.diego.demojpa.infrastructure.repositiry.ProyectService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




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


    @GetMapping("/roles")
    public List<Rol>finAllRoles(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "0") String value
        ) {
        // /api/roles?filter=name&value=Diego
        // /api/roles?filter=language&value=Java
        List<Rol> result = personService.findAllRolesByFilter(filter, value);
 
        return result;
    }
    

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol newRole(@Valid @RequestBody RoleRequest role){
        return personService.createNewRol(role.getName());
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