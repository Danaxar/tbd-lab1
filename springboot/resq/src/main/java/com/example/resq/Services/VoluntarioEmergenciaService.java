package com.example.resq.Services;

import com.example.resq.Entities.VoluntarioEmergencia;
import com.example.resq.Repositories.VoluntarioEmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioEmergenciaService {
    @Autowired
    VoluntarioEmergenciaRepository voluntarioEmergenciaRepository;

    public List<VoluntarioEmergencia> obtenerTodosVoluntariosEmergencia() {
        return voluntarioEmergenciaRepository.findAll();
    }

    public Integer cantidadVoluntarios(Integer idEmergencia){
        Integer salida = voluntarioEmergenciaRepository.countByIdEmergencia(idEmergencia);
        System.out.println("La cantidad de voluntarios registrados es: " + Integer.toString(salida));
        return salida;
    }

    public Boolean verificarRegistro(Integer idEmergencia, Integer idVoluntario){
        return voluntarioEmergenciaRepository.existsByIdEmergenciaAndIdVoluntario(idEmergencia, idVoluntario);
    }

    public Optional<VoluntarioEmergencia> obtenerVoluntarioEmergenciaPorId(Integer id) {
        return voluntarioEmergenciaRepository.findById(id);
    }

    public VoluntarioEmergencia guardarVoluntarioEmergencia(VoluntarioEmergencia voluntarioEmergencia) {
        return voluntarioEmergenciaRepository.save(voluntarioEmergencia);
    }

    public void eliminarVoluntarioEmergencia(Integer id) {
        voluntarioEmergenciaRepository.deleteById(id);
    }
}
