package com.example.resq.Repository;

import com.example.resq.Models.Emergencia;

import java.time.LocalDate;
import java.util.List;

public interface EmergenciaRepository {
    List<Emergencia> getAllEmergencias();
    Emergencia getEmergenciaById(Integer id);
    void saveEmergencia(Emergencia emergencia);
    void deleteEmergencia(Integer id);

    List<Emergencia> getEmergenciasByEstado(String estado);
}
