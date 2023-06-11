package com.example.resq.Services;

import com.example.resq.Entities.Tarea;
import com.example.resq.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    public Tarea getTareasById(Integer id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void crearTarea(Tarea tarea) {

        tareaRepository.crearTarea(tarea.getNombre(), tarea.getDescripcion(), tarea.getRegion(),
                    tarea.getLongitud(), tarea.getLatitud(), tarea.getIdEstado(), tarea.getIdEmergencia());
    }

    public List<Tarea> getTareasbyEmergencia(Integer id_emergencia) {
        return tareaRepository.getTareasbyEmergencia(id_emergencia);
    }

    public List<Tarea> getTareasbyRegion(String region) {
        return tareaRepository.getTareasbyRegion(region);
    }

    public void deleteTarea(Integer id) {
        tareaRepository.deleteById(id);
    }
}
