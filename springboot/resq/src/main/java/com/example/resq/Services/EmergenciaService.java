package com.example.resq.Services;

import com.example.resq.Entities.Emergencia;
import com.example.resq.Repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;

    @Autowired
    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.findAll();
    }

    public Emergencia getEmergenciaById(Integer id) {
        return emergenciaRepository.findById(id).orElse(null);
    }

    public Emergencia saveEmergencia(Emergencia emergencia) {
        return emergenciaRepository.save(emergencia);
    }

    public void deleteEmergencia(Integer id) {
        emergenciaRepository.deleteById(id);
    }
}
