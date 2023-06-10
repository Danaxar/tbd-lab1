package com.example.resq.Repositories;

import com.example.resq.Entities.VoluntarioEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioEmergenciaRepository extends JpaRepository<VoluntarioEmergencia, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
    public Integer countByIdEmergencia(Integer idEmergencia);
    public Boolean existsByIdEmergenciaAndIdVoluntario(Integer idEmergencia, Integer idVoluntario);
}