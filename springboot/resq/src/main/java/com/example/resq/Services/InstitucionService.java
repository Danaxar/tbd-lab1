package com.example.resq.Services;

import com.example.resq.Entities.Institucion;
import com.example.resq.Repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    @Autowired
    public InstitucionService(InstitucionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }

    public List<Institucion> getAllInstituciones() {
        return institucionRepository.findAll();
    }

    public Optional<Institucion> getInstitucionById(Integer id) {
        return institucionRepository.findById(id);
    }

    public Institucion createInstitucion(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    public Institucion updateInstitucion(Integer id, Institucion institucionDetails) {
        Optional<Institucion> institucion = institucionRepository.findById(id);
        if (institucion.isPresent()) {
            Institucion updatedInstitucion = institucion.get();
            updatedInstitucion.setNombre(institucionDetails.getNombre());
            return institucionRepository.save(updatedInstitucion);
        }
        return null;
    }

    public void deleteInstitucion(Integer id) {
        institucionRepository.deleteById(id);
    }

    public Institucion getByName(String nombre){
        return institucionRepository.getByNombre(nombre);
    }
}