package com.example.resq.Services;

import com.example.resq.Entities.Emergencia;
import com.example.resq.Repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void saveEmergencia(Emergencia emergencia) {

        emergenciaRepository.crearEmergencia(emergencia.getNombre(), emergencia.getGravedad(), emergencia.getFecha(), emergencia.getEstado(),
                                            emergencia.getRegion(), emergencia.getLongitud(), emergencia.getLatitud(), emergencia.getIdInstitucion());
    }

    public void deleteEmergencia(Integer id) {
        emergenciaRepository.deleteById(id);
    }
}
