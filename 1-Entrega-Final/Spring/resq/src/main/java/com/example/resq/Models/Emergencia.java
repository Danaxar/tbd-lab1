package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Emergencia {
    @JsonProperty("id_emergencia")
    private Integer id_emergencia;
    private String nombre;
    private String gravedad;
    private String fecha;
    private String estado;
    private String region;
    private Double longitud;
    private Double latitud;
    private String geom;
    private Integer id_institucion;

    public Integer getIdEmergencia() {
        return id_emergencia;
    }

    public void setIdEmergencia(Integer idEmergencia) {
        this.id_emergencia = idEmergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }

    public Integer getIdInstitucion() {
        return id_institucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.id_institucion = idInstitucion;
    }
}
