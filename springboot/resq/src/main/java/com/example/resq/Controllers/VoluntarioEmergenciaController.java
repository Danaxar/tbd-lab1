package com.example.resq.Controllers;

import com.example.resq.Entities.VoluntarioEmergencia;
import com.example.resq.Services.VoluntarioEmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voluntario-emergencias")
public class VoluntarioEmergenciaController {
    @Autowired
    VoluntarioEmergenciaService voluntarioEmergenciaService;

    @GetMapping
    public ResponseEntity<List<VoluntarioEmergencia>> obtenerTodosVoluntariosEmergencia() {
        List<VoluntarioEmergencia> voluntariosEmergencia = voluntarioEmergenciaService.obtenerTodosVoluntariosEmergencia();
        return new ResponseEntity<>(voluntariosEmergencia, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioEmergencia> obtenerVoluntarioEmergenciaPorId(@PathVariable Integer id) {
        Optional<VoluntarioEmergencia> voluntarioEmergencia = voluntarioEmergenciaService.obtenerVoluntarioEmergenciaPorId(id);
        return voluntarioEmergencia.map(voluntario -> new ResponseEntity<>(voluntario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/emergencia/{id}")
    public ResponseEntity<Integer> cantidadRegistrados(@PathVariable("id") Integer id) {
        Integer salida = voluntarioEmergenciaService.cantidadVoluntarios(id);
        return ResponseEntity.ok(salida);
    }

    @PostMapping
    public ResponseEntity<VoluntarioEmergencia> crearVoluntarioEmergencia(@RequestBody VoluntarioEmergencia voluntarioEmergencia) {
        VoluntarioEmergencia nuevoVoluntarioEmergencia = voluntarioEmergenciaService.guardarVoluntarioEmergencia(voluntarioEmergencia);
        return new ResponseEntity<>(nuevoVoluntarioEmergencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoluntarioEmergencia> actualizarVoluntarioEmergencia(
            @PathVariable Integer id, @RequestBody VoluntarioEmergencia voluntarioEmergencia) {
        Optional<VoluntarioEmergencia> voluntarioEmergenciaExistente = voluntarioEmergenciaService.obtenerVoluntarioEmergenciaPorId(id);
        if (voluntarioEmergenciaExistente.isPresent()) {
            voluntarioEmergencia.setIdVoluntarioEmergencia(id);
            VoluntarioEmergencia voluntarioEmergenciaActualizado = voluntarioEmergenciaService.guardarVoluntarioEmergencia(voluntarioEmergencia);
            return new ResponseEntity<>(voluntarioEmergenciaActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVoluntarioEmergencia(@PathVariable Integer id) {
        Optional<VoluntarioEmergencia> voluntarioEmergencia = voluntarioEmergenciaService.obtenerVoluntarioEmergenciaPorId(id);
        if (voluntarioEmergencia.isPresent()) {
            voluntarioEmergenciaService.eliminarVoluntarioEmergencia(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
