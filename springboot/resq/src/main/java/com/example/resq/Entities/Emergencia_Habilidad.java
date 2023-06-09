package com.example.resq.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Emergencia_Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmergencia;
    private Integer idHabilidad;
}
