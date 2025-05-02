package com.diego.demojpa.infrastructure.repositiry;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diego.demojpa.domain.Rol;
import com.diego.demojpa.domain.project;


@Service
public class ProyectServiceImpl implements ProyectService {

    private final RoleRepository roleRepository;
    
    private final ProjectRepository projectRepository;

    public ProyectServiceImpl(ProjectRepository _projectRepository, RoleRepository roleRepository) {
        projectRepository = _projectRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<project> findAllProjects() {
        return projectRepository.findAll(); 
    }
    
}
