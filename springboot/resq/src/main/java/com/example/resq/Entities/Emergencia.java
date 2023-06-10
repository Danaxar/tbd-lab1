package com.example.resq.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Emergencia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmergencia;
    private String nombre;
    private String gravedad;
    private LocalDate fecha;
    private String estado;
    private String region;
    private Double longitud;
    private Double latitud;

    @Column(name = "geom", columnDefinition = "geometry(Point,0)")
    private String geom;

    // FK
    private Integer idInstitucion;

    public void print() {
        System.out.println("Id de emergencia: " + this.idEmergencia);
        System.out.println("Nombre de emergencia: " + this.nombre);
        System.out.println("Gravedad de emergencia: " + this.gravedad);
        System.out.println("Fecha de emergencia: " + this.fecha);
        System.out.println("region de la emergencia: " + this.region);
        System.out.println("longitud de coordenada: " + this.longitud);
        System.out.println("latitud de coordenada: " + this.latitud);
        System.out.println("punto geometrico en el mapa: " + this.geom);

    }

}