package com.example.Curso.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Curso.entity.Profesores;
import com.example.Curso.repository.profesoresRepository;

@RestController
@RequestMapping("/api")
public class profesoresController {

    private final profesoresRepository profesoresRepository;

    public profesoresController(profesoresRepository profesoresRepository) {
        this.profesoresRepository = profesoresRepository;
    }
    
    @GetMapping("/profesores")
    public List<Profesores> getAllProfesores() {
        return profesoresRepository.findAll();
    }

    @GetMapping("/profesores/{id}")
    public ResponseEntity<Profesores> obtenerProfesores(@PathVariable String id) {
        return profesoresRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/profesor")
    public ResponseEntity<Profesores> añadirProfesor(@RequestBody Profesores profesores) {
        Profesores nuevo = profesoresRepository.save(profesores);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/profesores/{id}") 
    public ResponseEntity<Profesores> updateEspecialidad(
            @PathVariable String id,
            @RequestBody String nuevoEstado) {
 
            Profesores actualizado = updateEstado(id, nuevoEstado);
 
        if (actualizado == null) {
            // Puede ser porque no existe o porque el estado es inválido
            return ResponseEntity.badRequest().build();
        }
 
        return ResponseEntity.ok(actualizado);
    }

    // Normalizamos el estado
    public Profesores updateEstado(@PathVariable String id, @RequestBody String nuevaEspecialidad) {

        System.out.println(">>> id recibido: " + id);
        System.out.println(">>> especialidad recibida: '" + nuevaEspecialidad + "'");

        if (nuevaEspecialidad == null) {
            System.out.println(">>> especialidad es null");
        return null;
        }

        // Buscar moroso
        Profesores profesor = profesoresRepository.findById(id).orElse(null);
        if (profesor == null) {
            System.out.println(">>> profesor no encontrado");
        return null;
        }

        try {
            Profesores.Especialidad especialidad = Profesores.Especialidad
                    .valueOf(nuevaEspecialidad.trim().toUpperCase());
            profesor.setEspecialidad(especialidad);
        } catch (IllegalArgumentException e) {
            System.out.println(">>> enum inválido: " + nuevaEspecialidad);
            return null;
        }
        

        return profesoresRepository.save(profesor);
    }

    @DeleteMapping("/profesor/{id}")
    public ResponseEntity<Void> borrarProfesor(@PathVariable String id) {
    if (!profesoresRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }
    profesoresRepository.deleteById(id);
    return ResponseEntity.noContent().build();
    }
    
}

