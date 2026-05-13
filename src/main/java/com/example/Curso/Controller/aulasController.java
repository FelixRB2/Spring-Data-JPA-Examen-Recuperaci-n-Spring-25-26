package com.example.Curso.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curso.entity.Aulas;
import com.example.Curso.repository.aulasRepository;

@RestController
@RequestMapping("/api")
public class aulasController {

    private final aulasRepository aulasRepository;

    public aulasController(aulasRepository aulasRepository) {
        this.aulasRepository = aulasRepository;
    }
    
    @GetMapping("/aulas")
    public List<Aulas> getAllAulas() {
        return aulasRepository.findAll();
    }

    @GetMapping("/aulas/{id}")
    public ResponseEntity<Aulas> obtenerAula(@PathVariable String id) {
        return aulasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/aulas")
    public ResponseEntity<Aulas> añadirAula(@RequestBody Aulas aulas) {
        Aulas nuevo = aulasRepository.save(aulas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }


}
