package com.example.resq.Models;

public class Tarea {
    private Integer idTarea;
    private String nombre;
    private String descripcion;
    private String region;
    private Double longitud;
    private Double latitud;

    private String geom;

    // FK
    private Integer idEstado;
    private Integer idEmergencia;
}
