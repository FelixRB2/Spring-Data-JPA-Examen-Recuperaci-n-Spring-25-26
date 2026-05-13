package com.example.Curso.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesores {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id = UUID.randomUUID().toString();

    private String nombre;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    public enum Especialidad {
        INFORMATICA, COMERCIO, FINANZAS
    }

    public Profesores() {}

    public Profesores(String id, String nombre, String apellido1, String apellido2, Especialidad especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.especialidad = especialidad;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombreProfe() { return nombre; }
    public void setNombreProfe(String nombreProfe) { this.nombre = nombre; }
    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }
    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }
    public Especialidad getEspecialidad(Especialidad especialidad) { return especialidad;}
    public void setEspecialidad (Especialidad especialidad) { this.especialidad = especialidad;}

    
    
}
