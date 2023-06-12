package com.example.resq.Services;

import com.example.resq.Entities.Estado;
import com.example.resq.Repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    private final EstadoRepository estadoRepository;

    @Autowired
    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> getEstadoById(Integer id) {
        return estadoRepository.findById(id);
    }

    public Estado createEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado   updateEstado(Integer id, Estado estadoDetails) {
        Optional<Estado> estado = estadoRepository.findById(id);
        if (estado.isPresent()) {
            Estado updatedEstado = estado.get();
            updatedEstado.setNombre(estadoDetails.getNombre());
            return estadoRepository.save(updatedEstado);
        }
        return null;
    }

    public void deleteEstado(Integer id) {
        estadoRepository.deleteById(id);
    }

    public Estado getByNombre(String nombre){
        return estadoRepository.getByNombre(nombre);
    }
}
