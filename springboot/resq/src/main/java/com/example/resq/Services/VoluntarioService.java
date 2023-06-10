package com.example.resq.Services;

import com.example.resq.Entities.Voluntario;
import com.example.resq.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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


    @Transactional
    public void saveVoluntario(Voluntario voluntario) {
        voluntarioRepository.crearVoluntario(voluntario.getRut(), voluntario.getNombres(), voluntario.getApellidos(), voluntario.getFecha_nac(),
                voluntario.getDisponibilidad(), voluntario.getTelefono(), voluntario.getRol(), voluntario.getContrasena(), voluntario.getRegion(), voluntario.getLongitud(),
                voluntario.getLatitud());
    }

    public void deleteVoluntario(Integer id) {
        voluntarioRepository.deleteById(id);
    }

    public Optional<Voluntario> findByRut(String rut){
        return voluntarioRepository.findFirstByRut(rut);
    }
}
