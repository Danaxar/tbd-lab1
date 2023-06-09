package com.example.resq.Controllers;

import com.example.resq.Entities.EmergenciaHabilidad;
import com.example.resq.Services.EmergenciaHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emergencia-habilidades")
public class EmergenciaHabilidadController {
    @Autowired
    EmergenciaHabilidadService emergenciaHabilidadService;

    @GetMapping("/{id}")
    public ResponseEntity<EmergenciaHabilidad> getById(@PathVariable Integer id) {
        EmergenciaHabilidad emergenciaHabilidad = emergenciaHabilidadService.findById(id);
        return ResponseEntity.ok(emergenciaHabilidad);
    }

    @PostMapping
    public ResponseEntity<EmergenciaHabilidad> create(@RequestBody EmergenciaHabilidad emergenciaHabilidad) {
        EmergenciaHabilidad createdEmergenciaHabilidad = emergenciaHabilidadService.createEmergenciaHabilidad(emergenciaHabilidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmergenciaHabilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergenciaHabilidad> update(@PathVariable Integer id, @RequestBody EmergenciaHabilidad emergenciaHabilidad) {
        EmergenciaHabilidad updatedEmergenciaHabilidad = emergenciaHabilidadService.updateEmergenciaHabilidad(id, emergenciaHabilidad);
        return ResponseEntity.ok(updatedEmergenciaHabilidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        emergenciaHabilidadService.deleteEmergenciaHabilidad(id);
        return ResponseEntity.noContent().build();
    }
}
