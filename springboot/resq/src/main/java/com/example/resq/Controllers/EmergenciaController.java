package com.example.resq.Controllers;

import com.example.resq.Entities.Emergencia;
import com.example.resq.Entities.Habilidad;
import com.example.resq.Entities.Institucion;
import com.example.resq.Services.EmergenciaService;
import com.example.resq.Services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emergencias")
public class EmergenciaController {
    private final EmergenciaService emergenciaService;
    @Autowired
    private InstitucionService institucionService;

    @Autowired
    public EmergenciaController(EmergenciaService emergenciaService) {
        this.emergenciaService = emergenciaService;
    }

    @GetMapping
    public List<Emergencia> getAllEmergencias() {
        return emergenciaService.getAllEmergencias();
    }

    @GetMapping("/{id}")
    public Emergencia getEmergenciaById(@PathVariable Integer id) {
        return emergenciaService.getEmergenciaById(id);
    }

    @PostMapping
    public Emergencia saveEmergencia(@RequestBody Map<String, Object> json) {
        String nombre = (String) json.get("nombre");
        String gravedad = (String) json.get("gravedad");
        LocalDate fecha = LocalDate.parse((String) json.get("fecha"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String institucion = (String) json.get("institucion");
        String estado = (String) json.get("estado");
        ArrayList<String> habilidades = (ArrayList<String>) json.get("habilidades");
        System.out.println("Nombre: " + nombre);
        System.out.println("Gravedad: " + gravedad);
        System.out.println("Fecha: " + fecha.toString());
        System.out.println("Institucion: " + institucion);
        System.out.println("Habilidades " + habilidades);

        // Buscar id de la institucion
        Integer idInstitucion = institucionService.getByName(institucion).getIdInstitucion();

        Emergencia salida = new Emergencia();
        salida.setNombre(nombre);
        salida.setGravedad(gravedad);
        salida.setFecha(fecha);
        salida.setIdInstitucion(idInstitucion);
        salida.setEstado(estado);
        return emergenciaService.saveEmergencia(salida);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergencia(@PathVariable Integer id) {
        emergenciaService.deleteEmergencia(id);
    }
}
