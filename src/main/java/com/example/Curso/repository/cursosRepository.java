package com.example.Curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Curso.entity.Cursos;
import com.example.Curso.entity.Profesores;


public interface cursosRepository extends JpaRepository <Cursos, String> {


    
} 
