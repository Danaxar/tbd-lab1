package com.example.resq.Services;

import com.example.resq.Models.VoluntarioHabilidad;
import com.example.resq.Repository.VoluntarioHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario-habilidades")
public class VoluntarioHabilidadService {

    @Autowired
    private VoluntarioHabilidadRepository voluntarioHabilidadRepository;


    @GetMapping
    public List<VoluntarioHabilidad> getAllVoluntarioHabilidades() {
        return voluntarioHabilidadRepository.getAll();
    }

    @GetMapping("/{id}")
    public VoluntarioHabilidad getVoluntarioHabilidadById(@PathVariable("id") String id_str) {
        try {
            int id = Integer.parseInt(id_str);
            return voluntarioHabilidadRepository.getById(id);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un id válido");
            return null;
        }
    }

    @PostMapping
    public VoluntarioHabilidad createVoluntarioHabilidad(@RequestBody VoluntarioHabilidad voluntarioHabilidad) {
        voluntarioHabilidadRepository.create(voluntarioHabilidad);
        return voluntarioHabilidad;
    }

    @PutMapping("/{id}")
    public VoluntarioHabilidad updateVoluntarioHabilidad(@PathVariable("id") String id_str, @RequestBody VoluntarioHabilidad voluntarioHabilidad) {
        try {
            int id = Integer.parseInt(id_str);
            VoluntarioHabilidad existingVoluntarioHabilidad = voluntarioHabilidadRepository.getById(id);
            if (existingVoluntarioHabilidad != null) {
                voluntarioHabilidad.setIdVoluntarioHabilidad(id);
                voluntarioHabilidadRepository.update(voluntarioHabilidad);
                return voluntarioHabilidad;
            } else {
                System.out.println("El voluntario_habilidad con id " + id + " no existe.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un id válido");
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteVoluntarioHabilidad(@PathVariable("id") String id_str) {
        try {
            int id = Integer.parseInt(id_str);
            voluntarioHabilidadRepository.delete(id);
            System.out.println("Voluntario_habilidad con id " + id + " eliminado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un id válido");
        }
    }
}

