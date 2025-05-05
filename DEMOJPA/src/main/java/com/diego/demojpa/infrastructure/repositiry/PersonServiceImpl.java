package com.diego.demojpa.infrastructure.repositiry;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

import com.diego.demojpa.application.service.PersonService;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.Rol;
import com.diego.demojpa.infrastructure.error.RolDuplicateExeption;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        }else if (filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
            return personRepository.findAll();
    }

    @Override
    public Person patchPerson(Long id, Person personDto) {
        Optional<Person> person = personRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("no se encontro el usuario solicitado"));

        if (personDto.getName() != null) {
            person.get().setName(personDto.getName());
        }

        if (personDto.getLastName() != null) {
            person.get().setLastName(personDto.getLastName());
        }

        if (personDto.getLanguage() != null) {
            person.get().setLanguage(personDto.getLanguage());
        }
        personRepository.save(person);
        return person;
    }
}
