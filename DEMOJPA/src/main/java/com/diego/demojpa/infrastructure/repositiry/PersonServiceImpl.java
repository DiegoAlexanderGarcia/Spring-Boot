package com.diego.demojpa.infrastructure.repositiry;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

import com.diego.demojpa.application.service.PersonService;
import com.diego.demojpa.domain.Person;
import com.diego.demojpa.domain.Rol;
import com.diego.demojpa.infrastructure.error.RolDuplicateExeption;

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
    public List<Person> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        }else if (filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
            return personRepository.findAll();
    }
    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        return roleRepository.findAll();
    }

    @Override
    public Rol createNewRol(String name) {
        Rol newRol = new Rol();
        newRol.setName(name);

        if(getRolByName(name).isPresent()){
            throw new RolDuplicateExeption("El rol: " + name +" ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

        return roleRepository.save(newRol); 
    }

    private Optional<Rol> getRolByName(String rolName) {
        return roleRepository.findByName(rolName);
    }
}
