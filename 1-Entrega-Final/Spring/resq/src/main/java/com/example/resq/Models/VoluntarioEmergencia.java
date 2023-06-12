package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoluntarioEmergencia {
    private Integer id_voluntario_emergencia;
    @JsonProperty("id_voluntario")
    private Integer id_voluntario;
    @JsonProperty("id_emergencia")
    private Integer id_emergencia;

    public Integer getId_voluntario_emergencia() {
        return id_voluntario_emergencia;
    }

    public void setIdVoluntarioEmergencia(Integer id_voluntario_emergencia) {
        this.id_voluntario_emergencia = id_voluntario_emergencia;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
}
