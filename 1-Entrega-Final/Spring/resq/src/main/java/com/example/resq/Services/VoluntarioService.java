package com.example.resq.Services;

import com.example.resq.Models.Voluntario;
import com.example.resq.Repository.VoluntarioRepository;
import com.example.resq.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;
    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @Autowired
    public JwtUtils jwtUtils;

    @GetMapping
    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.findAllVoluntario();
    }

    @GetMapping("/{id}")
    public Voluntario getVoluntarioById(@PathVariable Integer id) {
        return voluntarioRepository.findVoluntarioById(id);
    }

    @GetMapping("/rut/{rut}")
    public Voluntario getVoluntarioByRut(@PathVariable String rut) {
        return voluntarioRepository.findVoluntarioByRut(rut);
    }

    @GetMapping("/{id_emergencia}/{limite}")
    public List<Voluntario> traerVolCercano(@PathVariable Integer id_emergencia,@PathVariable Integer limite) {
        return voluntarioRepository.traerVoluntariosCercanos(id_emergencia, limite);
    }

    @GetMapping("/emergencia/{id_emergencia}")
    public List<Voluntario> getVoluntariosByEmergencia(@PathVariable Integer id_emergencia) {
        return voluntarioRepository.getVoluntariosByEmergencia(id_emergencia);
    }

    @GetMapping("/client")
    public ResponseEntity<Voluntario> getClient(@RequestParam("rut") String rut) {
        Voluntario voluntario = voluntarioRepository.findVoluntarioByRut(rut);
        if (voluntario != null) {
            return ResponseEntity.ok(voluntario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void saveVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioRepository.saveVoluntario(voluntario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, Object> json) {
        String rut = (String) json.get("rut");
        String contrasena = (String) json.get("contrasena");
        Voluntario voluntario = voluntarioRepository.findVoluntarioByRut(rut);
        if (voluntario != null) {
            // Verificar si las contraseñas son iguales
            if (voluntario.getContrasena().equals(contrasena)) {
                System.out.println("Autentificado");
                //Generar jwt
                String token = jwtUtils.generateJwt(voluntario);
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

    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable Integer id) {
        voluntario.setId(id);
        Voluntario updatedVoluntario = voluntarioRepository.updateVoluntario(voluntario);
        if (updatedVoluntario != null) {
            return ResponseEntity.ok(updatedVoluntario);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteVoluntario(@PathVariable Integer id) {
        return voluntarioRepository.deleteVoluntario(id);
    }
}
