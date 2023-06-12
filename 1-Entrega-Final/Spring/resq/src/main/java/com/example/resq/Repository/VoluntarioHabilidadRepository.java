package com.example.resq.Repository;

import com.example.resq.Models.VoluntarioHabilidad;

import java.util.List;

public interface VoluntarioHabilidadRepository {
    List<VoluntarioHabilidad> getAll();

    VoluntarioHabilidad getById(int id);

    void create(VoluntarioHabilidad voluntarioHabilidad);

    void update(VoluntarioHabilidad voluntarioHabilidad);

    void delete(int id);
}

