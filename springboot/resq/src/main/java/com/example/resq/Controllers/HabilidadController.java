package com.example.resq.Controllers;

import com.example.resq.Entities.Habilidad;
import com.example.resq.Services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController {
    private final HabilidadService habilidadService;

    @Autowired
    public HabilidadController(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    @GetMapping
    public ResponseEntity<List<Habilidad>> obtenerTodasHabilidades() {
        List<Habilidad> habilidades = habilidadService.obtenerTodasHabilidades();
        return new ResponseEntity<>(habilidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> obtenerHabilidadPorId(@PathVariable("id") Long id) {
        Optional<Habilidad> habilidad = habilidadService.obtenerHabilidadPorId(id);
        return habilidad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Habilidad> guardarHabilidad(@RequestBody Habilidad habilidad) {
        Habilidad nuevaHabilidad = habilidadService.guardarHabilidad(habilidad);
        return new ResponseEntity<>(nuevaHabilidad, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabilidad(@PathVariable("id") Long id) {
        habilidadService.eliminarHabilidad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

