package com.diego.demojpa.infrastructure.repositiry;

import java.util.List;

import com.diego.demojpa.domain.project;

public interface ProyectService {
    List<project> findAllProjects();

}
