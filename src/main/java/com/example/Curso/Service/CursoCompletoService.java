package com.example.Curso.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Curso.entity.Aulas;
import com.example.Curso.entity.Cursos;
import com.example.Curso.entity.Profesores;
import com.example.Curso.repository.aulasRepository;
import com.example.Curso.repository.cursosRepository;
import com.example.Curso.repository.profesoresRepository;

@Service
public class CursoCompletoService {

    @Autowired
    private cursosRepository cursosRepo;

    @Autowired
    private profesoresRepository profesoresRepo;

    @Autowired
    private aulasRepository aulasRepo;

    public List<Object> obtenerDatos(
            String idCurso,
            String idProfesor,
            String idAula) {

        Cursos curso = cursosRepo.findById(idCurso).orElse(null);
        Profesores profesor = profesoresRepo.findById(idProfesor).orElse(null);
        Aulas aula = aulasRepo.findById(idAula).orElse(null);

        return Arrays.asList(curso, profesor, aula);
    }
}