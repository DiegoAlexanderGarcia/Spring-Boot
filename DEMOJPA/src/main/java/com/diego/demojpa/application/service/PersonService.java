package com.diego.demojpa.application.service;

import java.util.List;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.dto.PersonRequest;



public interface PersonService {

    public List<Person> findAllUsersByFilter(String filter, String value);
    public Person patchPerson(Long id, PersonRequest personDto);
}