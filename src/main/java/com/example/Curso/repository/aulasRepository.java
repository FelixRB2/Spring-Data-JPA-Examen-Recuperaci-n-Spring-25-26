package com.example.Curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Curso.entity.Aulas;

@Repository
public interface aulasRepository extends JpaRepository <Aulas, String> {
 


    
} 
