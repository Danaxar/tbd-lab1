package com.example.resq.Controllers;

import com.example.resq.Entities.Institucion;
import com.example.resq.Services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instituciones")
public class InstitucionController {
    private final InstitucionService institucionService;

    @Autowired
    public InstitucionController(InstitucionService institucionService) {
        this.institucionService = institucionService;
    }

    @GetMapping
    public ResponseEntity<List<Institucion>> getAllInstituciones() {
        System.out.println("Obteniendo todas las instituciones");
        List<Institucion> instituciones = institucionService.getAllInstituciones();
        return new ResponseEntity<>(instituciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institucion> getInstitucionById(@PathVariable Integer id) {
        Optional<Institucion> institucion = institucionService.getInstitucionById(id);
        return institucion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Institucion> createInstitucion(@RequestBody Institucion institucion) {
        System.out.println("Ingresando institucion...");
        Institucion createdInstitucion = institucionService.createInstitucion(institucion);
        return new ResponseEntity<>(createdInstitucion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institucion> updateInstitucion(
            @PathVariable Integer id,
            @RequestBody Institucion institucionDetails
    ) {
        Institucion updatedInstitucion = institucionService.updateInstitucion(id, institucionDetails);
        if (updatedInstitucion != null) {
            return new ResponseEntity<>(updatedInstitucion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitucion(@PathVariable Integer id) {
        institucionService.deleteInstitucion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
