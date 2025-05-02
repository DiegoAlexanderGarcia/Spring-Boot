package com.diego.demojpa.application.service;

import java.util.List;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.Rol;



public interface PersonService {

    public List<Person> findAllUsersByFilter(String filter, String value);
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol(String name);
}