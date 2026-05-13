package com.example.Curso.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "aulas")
public class Aulas {
    
    @Id
    //@Column(length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id = UUID.randomUUID().toString();

    @Column (name = "nombre_aula")
    private String nombreAula;

    private Integer capacidad;

    public Aulas() {}

    public Aulas(String id, String nombreAula, Integer capacidad) {
        this.id = id;
        this.nombreAula = nombreAula;
        this.capacidad = capacidad;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreAula() { return nombreAula; }
    public void setNombreAula(String nombreAula) { this.nombreAula = nombreAula; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

}
