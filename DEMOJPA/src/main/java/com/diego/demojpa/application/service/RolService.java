package com.diego.demojpa.application.service;

import java.util.List;

import com.diego.demojpa.domain.Rol;

public interface RolService {
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol(String name);
    public Rol removeRol(Long id);
}
