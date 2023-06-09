package com.example.resq.Services;

import com.example.resq.Entities.EmergenciaHabilidad;
import com.example.resq.Repositories.EmergenciaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EmergenciaHabilidadService {
    @Autowired
    private EmergenciaHabilidadRepository emergenciaHabilidadRepository;

    public EmergenciaHabilidad findById(Integer id) {
        return emergenciaHabilidadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la entidad con ID: " + id));
    }

    public EmergenciaHabilidad createEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad) {
        return emergenciaHabilidadRepository.save(emergenciaHabilidad);
    }

    public EmergenciaHabilidad updateEmergenciaHabilidad(Integer id, EmergenciaHabilidad emergenciaHabilidad) {
        EmergenciaHabilidad existingEmergenciaHabilidad = findById(id);
        existingEmergenciaHabilidad.setIdHabilidad(emergenciaHabilidad.getIdHabilidad());

        return emergenciaHabilidadRepository.save(existingEmergenciaHabilidad);
    }

    public void deleteEmergenciaHabilidad(Integer id) {
        EmergenciaHabilidad emergenciaHabilidad = findById(id);
        emergenciaHabilidadRepository.delete(emergenciaHabilidad);
    }
}
