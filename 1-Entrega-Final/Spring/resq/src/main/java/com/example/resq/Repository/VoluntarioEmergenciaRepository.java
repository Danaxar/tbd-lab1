package com.example.resq.Repository;

import com.example.resq.Models.Emergencia;
import com.example.resq.Models.VoluntarioEmergencia;

import java.util.List;

public interface VoluntarioEmergenciaRepository {
        List<VoluntarioEmergencia> getAll();
        VoluntarioEmergencia getById(Integer id);
        void save(Integer id_emergencia, Integer id_voluntario);
        Boolean delete(Integer id);

        Integer cantidadVoluntarios(Integer id_emergencia);

        Boolean verificarRegistro(Integer id_voluntario, Integer id_emergencia);
}
