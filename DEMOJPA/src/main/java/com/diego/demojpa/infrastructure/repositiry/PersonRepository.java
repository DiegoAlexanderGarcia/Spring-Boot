package com.diego.demojpa.infrastructure.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.demojpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String name);
    
}
