package com.example.resq.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Voluntario {
    @JsonProperty("id")
    private Integer id;
    private String rut;
    private String nombres;
    private String apellidos;
    private Date fecha_nac;
    private String disponibilidad;
    private String telefono;
    private String rol;
    private String contrasena;
    private String region;
    private Double longitud;
    private Double latitud;
    private String geom;

    // Getters
    public Integer getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public String getContrasena() {
        return contrasena;
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

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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


}
