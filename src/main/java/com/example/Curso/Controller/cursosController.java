package com.example.Curso.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curso.entity.Aulas;
import com.example.Curso.entity.Cursos;
import com.example.Curso.entity.Profesores;
import com.example.Curso.repository.aulasRepository;
import com.example.Curso.repository.cursosRepository;
import com.example.Curso.repository.profesoresRepository;

@RestController
@RequestMapping("/api")
public class cursosController {

    private final cursosRepository cursosRepository;
    /*private final profesoresRepository profesoresRepository;
    private final aulasRepository aulasRepository;*/

    public cursosController(cursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    /*public profesoresController(profesoresRepository profesoresRepository) {
        this.profesoresRepository = profesoresRepository;
    }

    public aulasController(aulasRepository aulasRepository) {
        this.aulasRepository = aulasRepository;
    }*/

    @GetMapping("/cursos")
    public List<Cursos> getAllCursos() {
        return cursosRepository.findAll();
    }


    @GetMapping("/cursos/{id}")
    public ResponseEntity<Cursos> obtenerCursos(@PathVariable String id) {
        return cursosRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cursos")
    public ResponseEntity<Cursos> añadirCursos(@RequestBody Cursos cursos) {
        Cursos nuevo = cursosRepository.save(cursos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Void> borrarCursos(@PathVariable String id) {
    if (!cursosRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }
    cursosRepository.deleteById(id);
    return ResponseEntity.noContent().build();
    }

    
}
