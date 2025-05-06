package com.diego.demojpa.infrastructure.repositiry;

import java.util.List;

import org.springframework.stereotype.Service;


import com.diego.demojpa.domain.project;


@Service
public class ProyectServiceImpl implements ProyectService {

    private final ProjectRepository projectRepository;

    public ProyectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    @Override
    public List<project> findAllProjects() {
        return projectRepository.findAll(); 
    }
    
}
