package com.example.resq.Controllers;

import com.example.resq.Entities.Voluntario;
import com.example.resq.Services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/voluntarios")
//@CrossOrigin("*")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    @Autowired
    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @GetMapping
    public ResponseEntity<List<Voluntario>> getAllVoluntarios() {
        List<Voluntario> voluntarios = voluntarioService.getAllVoluntarios();
        return ResponseEntity.ok(voluntarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> getVoluntarioById(@PathVariable Integer id) {
        Optional<Voluntario> voluntario = voluntarioService.getVoluntarioById(id);
        if (voluntario.isPresent()) {
            return ResponseEntity.ok(voluntario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Voluntario> createVoluntario(@RequestBody Voluntario voluntario) {
        Voluntario savedVoluntario = voluntarioService.saveVoluntario(voluntario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVoluntario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoluntario(@PathVariable Integer id) {
        voluntarioService.deleteVoluntario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Voluntario> getVoluntarioByRut(@PathVariable("rut") String rut) {
        Optional<Voluntario> voluntario = voluntarioService.findByRut(rut);
        if (voluntario.isPresent()) {
            return ResponseEntity.ok(voluntario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Voluntario> login(@RequestBody Map<String, Object> json) {
        String rut = (String) json.get("rut");
        String contrasena = (String) json.get("contrasena");

        Optional<Voluntario> voluntario = voluntarioService.findByRut(rut);
        if (voluntario.isPresent()) {
            // Verificar si las contraseñas son iguales
            if (voluntario.get().getContrasena().equals(contrasena)) {
                System.out.println("Autentificado");
                return ResponseEntity.ok(voluntario.get());
            } else {
                System.out.println("Contrasena incorrecta");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
