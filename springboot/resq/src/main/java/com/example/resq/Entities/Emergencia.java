package com.example.resq.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Emergencia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmergencia;
    private String nombre;
    private String gravedad;
    private LocalDate fecha;

    // FK
    private Integer idInstitucion;

    public void print() {
        System.out.println("Id de emergencia: " + this.idEmergencia);
        System.out.println("Nombre de emergencia: " + this.nombre);
        System.out.println("Gravedad de emergencia: " + this.gravedad);
        System.out.println("Fecha de emergencia: " + this.fecha);
        System.out.println("Id de institución: " + this.idInstitucion);
    }

}