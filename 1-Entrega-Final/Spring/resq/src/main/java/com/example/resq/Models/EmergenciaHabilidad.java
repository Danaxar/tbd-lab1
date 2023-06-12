package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class EmergenciaHabilidad {
    @JsonProperty("id_emergencia_habilidad")
    private Integer id_emergencia_habilidad;
    @JsonProperty("id_emergencia")
    private Integer id_emergencia;
    @JsonProperty("id_habilidad")
    private Integer id_habilidad;

    public Integer getId() {
        return id_emergencia_habilidad;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId(Integer id_emergencia_habilidad) {
        this.id_emergencia_habilidad = id_emergencia_habilidad;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
