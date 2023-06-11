package com.example.resq.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarea;
    private String nombre;
    private String descripcion;
    private String region;
    private Double longitud;
    private Double latitud;

    @Column(name = "geom", columnDefinition = "geometry(Point,0)")
    private String geom;

    // FK
    private Integer idEstado;
    private Integer idEmergencia;
}