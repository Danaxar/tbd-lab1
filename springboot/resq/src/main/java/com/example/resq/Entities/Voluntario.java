package com.example.resq.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rut;
    private String nombres;
    private String apellidos;
    @Column(columnDefinition = "DATE")
    private Date fecha_nac;
    private String disponibilidad;
    private String telefono;
    private String rol;
    private String contrasena;
    private String region;
    private Double longitud;
    private Double latitud;

    @Column(name = "geom", columnDefinition = "geometry(Point,0)")
    private String geom;
}
