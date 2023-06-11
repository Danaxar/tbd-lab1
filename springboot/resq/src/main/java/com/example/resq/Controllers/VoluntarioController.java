package com.example.resq.Controllers;

import com.example.resq.Entities.Voluntario;
import com.example.resq.Services.VoluntarioService;
import com.example.resq.Util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    public JwtUtils jwtUtils;

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
    public void createVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioService.saveVoluntario(voluntario);
    }

    @GetMapping("/{id_emergencia}/{limite}")
    public ResponseEntity<List<Voluntario>> traerVolCercano(@PathVariable Integer id_emergencia, @PathVariable Integer limite) {
        List<Voluntario> voluntario = voluntarioService.traerVoluntariosCercanos(id_emergencia, limite);
        if (voluntario != null) {
            return ResponseEntity.ok(voluntario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/emergencia/{id_emergencia}")
    public ResponseEntity<List<Voluntario>> getVoluntarioByEmergencia(@PathVariable Integer id_emergencia) {
        List<Voluntario> voluntarios = voluntarioService.getVoluntarioByEmergencia(id_emergencia);
        if (voluntarios != null) {
            return ResponseEntity.ok(voluntarios);
        } else {
            return ResponseEntity.notFound().build();
        }
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
    public ResponseEntity<String> login(@RequestBody Map<String, Object> json) {
        String rut = (String) json.get("rut");
        String contrasena = (String) json.get("contrasena");

        Optional<Voluntario> voluntario = voluntarioService.findByRut(rut);
        if (voluntario.isPresent()) {
            // Verificar si las contraseñas son iguales
            if (voluntario.get().getContrasena().equals(contrasena)) {
                System.out.println("Autentificado");
                // Generar jwt
                String token = jwtUtils.generateJwt(voluntario.get());
                System.out.println("JWT generado: " + token);
                //return ResponseEntity.ok(voluntario.get());
                return ResponseEntity.ok(token);
            } else {
                System.out.println("Contrasena incorrecta");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/client")
    public ResponseEntity<Voluntario> getClient(@RequestParam("rut") String rut) {
        Optional<Voluntario> voluntario = voluntarioService.findByRut(rut);
        if (voluntario.isPresent()) {
            return ResponseEntity.ok(voluntario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestHeader String headers) throws Exception{
        System.out.println(headers);
        return null;
    }


}
