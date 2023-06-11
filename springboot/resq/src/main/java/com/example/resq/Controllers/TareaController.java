package com.example.resq.Controllers;

import com.example.resq.Entities.Tarea;
import com.example.resq.Services.EstadoService;
import com.example.resq.Services.InstitucionService;
import com.example.resq.Services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    private final TareaService tareaService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    public Tarea getTareasById(@PathVariable Integer id) {
        return tareaService.getTareasById(id);
    }

    @GetMapping("/emergencia/{id_emergencia}")
    public List<Tarea> getTareasByEmergencia(@PathVariable Integer id_emergencia) {
        return tareaService.getTareasbyEmergencia(id_emergencia);
    }

    @PostMapping
    public void crearTareas(@RequestBody Map<String, Object> json) {
        String nombre = (String) json.get("nombre");
        String descripcion = (String) json.get("descripcion");
        String estado = (String) json.get("estado");
        String region = (String) json.get("region");
        Double longitud = (Double) json.get("longitud");
        Double latitud = (Double) json.get("latitud");
        Integer idEmergencia = (Integer) json.get("idEmergencia");

        System.out.println("Nombre: " + nombre);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Region: " + region);
        System.out.println("Longitud: " + longitud);
        System.out.println("Latitud: " + latitud);
        System.out.println("idEmergencia: "+ idEmergencia);

        Integer idEstado = estadoService.getByNombre(estado).getIdEstado();

        Tarea salida = new Tarea();
        salida.setNombre(nombre);
        salida.setDescripcion(descripcion);
        salida.setRegion(region);
        salida.setIdEstado(idEstado);
        salida.setLongitud(longitud);
        salida.setLatitud(latitud);
        salida.setIdEmergencia(idEmergencia);

        System.out.println(salida);
        tareaService.crearTarea(salida);
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Integer id) {
        tareaService.deleteTarea(id);
    }
}
