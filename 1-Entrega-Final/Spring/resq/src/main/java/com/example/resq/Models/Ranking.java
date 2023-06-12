package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Ranking {
    @JsonProperty("id_ranking")
    private Integer id_ranking;
    @JsonProperty("id_voluntario")
    private Integer id_voluntario;
    @JsonProperty("id_tarea")
    private Integer id_tarea;

    public Integer getId() {
        return id_ranking;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId(Integer id_ranking) {
        this.id_ranking = id_ranking;
    }

    public void setId_emergencia(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public void setId_habilidad(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }
}