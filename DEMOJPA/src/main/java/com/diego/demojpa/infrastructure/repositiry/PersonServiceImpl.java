package com.diego.demojpa.infrastructure.repositiry;

import java.util.List;
import java.util.Optional;

import com.diego.demojpa.application.service.PersonService;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.Rol;
import com.diego.demojpa.domain.pasport;
import com.diego.demojpa.domain.dto.PersonRequest;
import com.diego.demojpa.domain.dto.PersonResponse;
import com.diego.demojpa.infrastructure.error.RolDuplicateExeption;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<PersonResponse> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findAll().stream().map((person) ->{ 
                PersonResponse response = new PersonResponse();
                    response.setName(person.getName());
                    response.setSurname(person.getLastName());
                    response.setSkill(person.getLanguage());
                    response.setPassport(person.getPasport()!= null);
                    return response;
                }).toList();
        }else if (filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findAll().stream().map((person) ->{ 
                PersonResponse response = new PersonResponse();
                    response.setName(person.getName());
                    response.setSurname(person.getLastName());
                    response.setSkill(person.getLanguage());
                    response.setPassport(person.getPasport()!= null);
                    return response;
                }).toList();
        }
            return personRepository.findAll().stream().map((person) ->{ 
                PersonResponse response = new PersonResponse();
                    response.setName(person.getName());
                    response.setSurname(person.getLastName());
                    response.setSkill(person.getLanguage());
                    response.setPassport(person.getPasport()!= null);
                    return response;
                }).toList();
    }

    @Override
    public PersonResponse patchPerson(Long id, PersonRequest personDto) {
       Person person = personRepository.findById(id)
       .orElseThrow(() -> new EntityNotFoundException("No se encontro el usuario solicitado"));
        
        if(personDto.getName() != null) {
            person.setName(personDto.getName());
        }

        if(personDto.getSurname() != null) {
            person.setLastName(personDto.getSurname());
        }

        if (personDto.getSkill() != null) {
            person.setLanguage(personDto.getSkill());
        }

        personRepository.save(person);

        PersonResponse response = new PersonResponse();
        response.setName(person.getName());
        response.setSurname(person.getLastName());
        response.setSkill(person.getLanguage());
        response.setPassport(person.getPasport() != null);
        
        return response;

    }

    @Override
    public PersonResponse createnewUser(PersonRequest personDto) {
        Optional<Person> person = personRepository.findPersonByPassportNumber(personDto.getPassport());

        if (person.isPresent()) {
            throw new RolDuplicateExeption("El pasaporte ya existe", HttpStatus.CONFLICT);
        }

        Rol usersRol = roleRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException(
                    "No se encontro el rol solicitado"));

        Person newPerson = new Person();
        newPerson.setName(personDto.getName());
        newPerson.setLastName(personDto.getSurname());
        newPerson.setLanguage(personDto.getSkill());
        newPerson.setRole(usersRol);

        pasport passport = new pasport();
        passport.setPerson(newPerson);
        passport.setNumber(personDto.getPassport());

        Person save = personRepository.save(newPerson);



        PersonResponse response = new PersonResponse();
        response.setName(save.getName());
        response.setSurname(save.getLastName());
        response.setSkill(save.getLanguage());
        response.setPassport(save.getPasport() != null);
        return response;
    }

}
