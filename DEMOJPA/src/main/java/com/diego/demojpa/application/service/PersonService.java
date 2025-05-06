package com.diego.demojpa.application.service;

import java.util.List;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.dto.PersonRequest;
import com.diego.demojpa.domain.dto.PersonResponse;



public interface PersonService {

    public List<PersonResponse> findAllUsersByFilter(String filter, String value);
    public Person patchPerson(Long id, PersonRequest personDto);
    public PersonResponse createnewUser(PersonRequest personDto);
}