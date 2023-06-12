package com.example.resq.Repository;

import com.example.resq.Models.Tarea;

import java.util.List;

public interface TareaRepository {
    public List<Tarea> findAll();
    public Tarea findById(Integer id);
    public List<Tarea> findByNombre(String nombre);
    public List<Tarea> findByEmergencia(Integer id_emergencia);
    public List<Tarea> findByRegion(String region);
    public Tarea save(Tarea tarea);
    public Tarea update(Tarea tarea);

    public boolean deleteTarea(Integer id);
}
