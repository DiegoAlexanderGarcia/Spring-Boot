package com.diego.demojpa.infrastructure.repositiry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.demojpa.domain.Rol;

public interface RoleRepository extends JpaRepository<Rol, Long> {
        Optional<Rol> findByName(String name);
}
