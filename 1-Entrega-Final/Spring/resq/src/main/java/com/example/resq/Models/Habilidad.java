package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Habilidad {
    @JsonProperty("id_habilidad")
    private Integer id_habilidad;
    @JsonProperty("nombre")
    private String nombre;

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}