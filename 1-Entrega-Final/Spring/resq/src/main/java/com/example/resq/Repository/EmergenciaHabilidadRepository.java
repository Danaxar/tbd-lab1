package com.example.resq.Repository;

import com.example.resq.Models.EmergenciaHabilidad;
import com.example.resq.Models.Habilidad;
import org.sql2o.Connection;

import java.util.List;

public interface EmergenciaHabilidadRepository {
    public List<EmergenciaHabilidad> findAll();
    public EmergenciaHabilidad findById(Integer id);
    public List<EmergenciaHabilidad> findByHabilidad(Integer id_habilidad);
    public List<EmergenciaHabilidad> findByEmergencia(Integer id_emergencia);
    public EmergenciaHabilidad save(EmergenciaHabilidad emergenciaHabilidad);
    public EmergenciaHabilidad update(EmergenciaHabilidad emergenciaHabilidad);
    public boolean delete(Integer id);
}
