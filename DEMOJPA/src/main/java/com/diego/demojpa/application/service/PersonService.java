package com.diego.demojpa.application.service;

import java.util.List;
import com.diego.demojpa.domain.Person;



public interface PersonService {

    public List<Person> findAllByFilter(String filter, String value);
    
}