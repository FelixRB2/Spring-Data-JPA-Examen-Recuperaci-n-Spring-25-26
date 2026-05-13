package com.example.Curso.Service;

import org.springframework.stereotype.Service;

import com.example.Curso.entity.Cursos;
import com.example.Curso.entity.Profesores;
import com.example.Curso.repository.cursosRepository;
import com.example.Curso.repository.profesoresRepository;

@Service
public class cursosService {
    
    private final cursosRepository cursosRepository;
    private final profesoresRepository profesoresRepository;

    public cursosService(cursosRepository cursosRepository,
                         profesoresRepository profesoresRepository) {
        this.cursosRepository = cursosRepository;
        this.profesoresRepository = profesoresRepository;
    }


    public Cursos actualizarProfesor(String cursoId, String profesorId) {
        Cursos curso = cursosRepository.findById(cursoId)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado: " + cursoId));

        Profesores profesor = profesoresRepository.findById(profesorId.trim())
            .orElseThrow(() -> new RuntimeException("Profesor no encontrado: " + profesorId));

        curso.setProfesor(profesor);
        return cursosRepository.save(curso);
    }
}
