package com.example.resq.Controllers;

import com.example.resq.Entities.Tarea;
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

    @PostMapping
    public void crearTareas(@RequestBody Map<String, Object> json) {
        String nombre = (String) json.get("nombre");
        String descripcion = (String) json.get("descripcion");
        String region = (String) json.get("region");
        Double longitud = (Double) json.get("longitud");
        Double latitud = (Double) json.get("latitud");

        System.out.println("Nombre: " + nombre);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Region: " + region);
        System.out.println("Longitud: " + longitud);
        System.out.println("Latitud: " + latitud);

        Tarea salida = new Tarea();
        salida.setNombre(nombre);
        salida.setDescripcion(descripcion);
        salida.setRegion(region);
        salida.setLongitud(longitud);
        salida.setLatitud(latitud);
        tareaService.crearTarea(salida);
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Integer id) {
        tareaService.deleteTarea(id);
    }
}
