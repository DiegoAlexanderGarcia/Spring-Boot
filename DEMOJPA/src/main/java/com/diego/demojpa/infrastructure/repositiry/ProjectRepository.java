package com.diego.demojpa.infrastructure.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.demojpa.domain.project;

public interface ProjectRepository  extends JpaRepository<project, Long>{

}
