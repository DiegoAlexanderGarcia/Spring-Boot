package com.diego.demojpa.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.demojpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    //List<Person> findByLanguageEquals(String name);
    //List<Person> findByLastNameList(String name);
}
