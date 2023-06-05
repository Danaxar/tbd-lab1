package com.example.resq.Services;

import com.example.resq.Entities.Voluntario;
import com.example.resq.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VoluntarioService {

    @Autowired
    private final VoluntarioRepository voluntarioRepository;

    @Autowired
    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.findAll();
    }

    public Optional<Voluntario> getVoluntarioById(Integer id) {
        return voluntarioRepository.findById(id);
    }

    public Voluntario saveVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    public void deleteVoluntario(Integer id) {
        voluntarioRepository.deleteById(id);
    }

    public Optional<Voluntario> findByRut(String rut){
        return voluntarioRepository.findByRut(rut);
    }
}
