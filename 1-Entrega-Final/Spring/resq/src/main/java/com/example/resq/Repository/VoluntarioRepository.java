package com.example.resq.Repository;

import com.example.resq.Models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {
    public List<Voluntario> findAllVoluntario();

    public Voluntario findVoluntarioById(Integer id);

    public Voluntario findVoluntarioByRut(String rut);

    public List<Voluntario> traerVoluntariosCercanos(Integer id_emergencia, Integer limite);

    public List<Voluntario> getVoluntariosByEmergencia(Integer id_emergencia);

    public void saveVoluntario(Voluntario voluntario);

    public Voluntario updateVoluntario(Voluntario voluntario);

    public boolean deleteVoluntario(Integer id);
}
