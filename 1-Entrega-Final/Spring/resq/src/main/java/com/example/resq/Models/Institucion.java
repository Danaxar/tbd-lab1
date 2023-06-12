package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Institucion {

    @JsonProperty("id_institucion")
    private Integer id_Institucion;
    @JsonProperty("nombre")
    private String nombre;

    public Integer getId_Institucion() {
        return id_Institucion;
    }

    public void setId_Institucion(Integer id_Institucion) {
        this.id_Institucion = id_Institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
