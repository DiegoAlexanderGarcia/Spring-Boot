package com.diego.demojpa.infrastructure.repositiry;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.diego.demojpa.application.service.RolService;
import com.diego.demojpa.domain.Rol;
import com.diego.demojpa.infrastructure.error.RolDuplicateExeption;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RolServiceImpl implements RolService {
    
    private final RoleRepository roleRepository;
        
        public RolServiceImpl(RoleRepository roleRepository) {
            this.roleRepository = roleRepository;
        }

        @Override
        public Rol removeRol (Long id){

            Optional<Rol> rol = roleRepository.findById(id);

            if (!rol.isPresent()){
                throw new EntityNotFoundException("el rol no se encuentra en la base de datos");
            }

            if (!rol.get().getPersons().isEmpty()){
                throw new EntityNotFoundException("el rol no se puede eliminar porque tiene personas asociadas");

            }
            roleRepository.deleteById(id);
            return rol.get();
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
