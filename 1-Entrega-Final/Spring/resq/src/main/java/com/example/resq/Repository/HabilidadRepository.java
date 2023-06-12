package com.example.resq.Repository;

import com.example.resq.Models.Habilidad;

import java.util.List;

public interface HabilidadRepository {
    public List<Habilidad> findAll();
    public Habilidad findById(Integer id);
    public Habilidad save(Habilidad habilidad);
    public Habilidad update(Habilidad habilidad);
    public boolean delete(Integer id);
}

