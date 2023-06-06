package com.example.resq.Services;

import com.example.resq.Entities.Habilidad;
import com.example.resq.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    @Autowired
    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    public List<Habilidad> obtenerTodasHabilidades() {
        return habilidadRepository.findAll();
    }

    public Optional<Habilidad> obtenerHabilidadPorId(Long id) {
        return habilidadRepository.findById(id);
    }

    public Habilidad guardarHabilidad(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    public void eliminarHabilidad(Long id) {
        habilidadRepository.deleteById(id);
    }
}

