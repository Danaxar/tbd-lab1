package com.example.resq.Services;

import com.example.resq.Models.Tarea;
import com.example.resq.Repository.EstadoRepository;
import com.example.resq.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tareas")
public class TareaService {
    private final TareaRepository tareaRepository;
    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarea getTareasById(@PathVariable Integer id) {
        return tareaRepository.findById(id);
    }

    @GetMapping("/emergencia/{id_emergencia}")
    public List<Tarea> getTareasByEmergencia(@PathVariable Integer id_emergencia) {
        return tareaRepository.findByEmergencia(id_emergencia);
    }

    @GetMapping("/region")
    public List<Tarea> getTareasByRegion(@RequestParam("region") String region) {
        return tareaRepository.findByRegion(region);
    }

    @PostMapping
    public void crearTareas(@RequestBody Map<String, Object> json) {
        String nombre = (String) json.get("nombre");
        String descripcion = (String) json.get("descripcion");
        String estado = (String) json.get("estado");
        String region = (String) json.get("region");
        Double longitud = (Double) json.get("longitud");
        Double latitud = (Double) json.get("latitud");
        Integer id_estado = estadoRepository.getIdEstado(estado);
        Integer id_emergencia = (Integer) json.get("idEmergencia");

        Tarea salida = new Tarea();
        salida.setNombre(nombre);
        salida.setDescripcion(descripcion);
        salida.setId_estado(id_estado);
        salida.setRegion(region);
        salida.setLongitud(longitud);
        salida.setLatitud(latitud);
        salida.setId_emergencia(id_emergencia);

        tareaRepository.save(salida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Integer id, @RequestBody Tarea tarea) {
        tarea.setId_tarea(id);
        Tarea updatedTarea = tareaRepository.update(tarea);
        if (updatedTarea == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(updatedTarea);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarTareas(@PathVariable Integer id) {
        tareaRepository.deleteTarea(id);
    }
}
