package com.diego.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.demojpa.domain.project;
import com.diego.demojpa.infrastructure.repositiry.ProyectService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProyectService proyectService;

    public ProjectController(ProyectService proyectService) {
        this.proyectService = proyectService;
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
