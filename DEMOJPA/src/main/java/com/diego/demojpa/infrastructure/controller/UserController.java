package com.diego.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.demojpa.application.service.PersonService;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.dto.PersonRequest;
import com.diego.demojpa.domain.dto.PersonResponse;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final PersonService personService;

    public UserController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/users")
    public List<PersonResponse> findAllUsers(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "0") String value
        ) {
        // /api/users?filter=name&value=Diego
        // /api/users?filter=language&value=Java
        List<PersonResponse> result = personService.findAllUsersByFilter(filter, value);
 
        return result;
    }

    @PostMapping("path")
    public String postMethodName(@RequestBody PersonRequest entity) {
        
        return null;
    }
    

    @PatchMapping("/users/{Id}")
    public ResponseEntity<Person> parcialUpdatePerson(@PathVariable Long id, @RequestBody PersonRequest personDto){

        return ResponseEntity.badRequest().build();
    }
    
}
