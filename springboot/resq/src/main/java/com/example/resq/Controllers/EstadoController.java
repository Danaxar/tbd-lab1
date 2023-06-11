package com.example.resq.Controllers;

import com.example.resq.Entities.Estado;
import com.example.resq.Services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    private final EstadoService estadoService;

    @Autowired
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados() {
        System.out.println("Obteniendo todos los estados");
        List<Estado> estados = estadoService.getAllEstados();
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Integer id) {
        Optional<Estado> estado = estadoService.getEstadoById(id);
        return estado.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
        System.out.println("Ingresando estado...");
        Estado createdEstado = estadoService.createEstado(estado);
        return new ResponseEntity<>(createdEstado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(
            @PathVariable Integer id,
            @RequestBody Estado estadoDetails
    ) {
        Estado updatedEstado = estadoService.updateEstado(id, estadoDetails);
        if (updatedEstado != null) {
            return new ResponseEntity<>(updatedEstado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer id) {
        estadoService.deleteEstado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

