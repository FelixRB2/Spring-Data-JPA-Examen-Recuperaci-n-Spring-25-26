package com.example.Curso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Curso.Service.CursoCompletoService;

@RestController
@RequestMapping("/curso-completo")
public class CursoCompletoController {

    @Autowired
    private CursoCompletoService service;

    @GetMapping("/{idCurso}/{idProfesor}/{idAula}")
    public List<Object> obtenerDatos(
            @PathVariable String idCurso,
            @PathVariable String idProfesor,
            @PathVariable String idAula) {

        return service.obtenerDatos(idCurso, idProfesor, idAula);
    }
}