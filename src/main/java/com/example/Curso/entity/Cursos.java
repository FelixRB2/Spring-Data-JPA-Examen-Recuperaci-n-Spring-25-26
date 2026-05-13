package com.example.Curso.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Cursos {

    @Id
    @Column(length = 36)
    private String id = UUID.randomUUID().toString();

    private String nombre_curso;

    private Integer horas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesores profesor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aula_id", nullable = false)
    private Aulas aula;

    public Cursos() {}

    public Cursos(String nombre_curso, Integer horas, Profesores profesor, Aulas aula) {
        this.nombre_curso = nombre_curso;
        this.horas = horas;
        this.profesor = profesor;
        this.aula = aula;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre_curso; }
    public void setNombre(String nombre_curso) { this.nombre_curso = nombre_curso; }

    public Integer getHoras() {return horas; }
    public void setHoras(Integer horas) {this.horas = horas; }

    public Profesores getProfesor() {return profesor;}
    public void setProfesor(Profesores profesor) {this.profesor = profesor;} 

    public Aulas getAula() {return aula;}
    public void setAula(Aulas aula) {this.aula = aula;}

    
}
