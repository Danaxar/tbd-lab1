package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {
    @JsonProperty("id_tarea")
    private Integer id_tarea;
    private String nombre;
    private String descripcion;
    private String region;
    private Double longitud;
    private Double latitud;

    private String geom;

    // FK
    private Integer id_estado;
    @JsonProperty("idEmergencia")
    private Integer id_emergencia;

    // Getters
    public Integer getId_tarea() {
        return id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRegion() {
        return region;
    }

    public Double getLongitud() {
        return longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public String getGeom() {
        return geom;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    // Setters

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

}
