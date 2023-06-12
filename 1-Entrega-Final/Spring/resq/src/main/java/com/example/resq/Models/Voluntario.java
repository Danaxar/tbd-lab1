package com.example.resq.Models;

import java.util.Date;

public class Voluntario {
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

    public Integer getId(){
        return id;
    }
}
