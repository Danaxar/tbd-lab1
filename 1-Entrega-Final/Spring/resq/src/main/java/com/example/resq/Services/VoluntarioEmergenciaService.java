package com.example.resq.Services;

import com.example.resq.Models.VoluntarioEmergencia;
import com.example.resq.Repository.VoluntarioEmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario-emergencias")
public class VoluntarioEmergenciaService {
    @Autowired
    VoluntarioEmergenciaRepository voluntarioEmergenciaRepository;

    @GetMapping
    public List<VoluntarioEmergencia> obtenerTodosVoluntariosEmergencia() {
        List<VoluntarioEmergencia> voluntariosEmergencia = voluntarioEmergenciaRepository.getAll();
        return  voluntariosEmergencia;
    }

    @GetMapping("/{id}")
    public VoluntarioEmergencia obtenerVoluntarioEmergenciaPorId(@PathVariable Integer id) {
        VoluntarioEmergencia voluntarioEmergencia = voluntarioEmergenciaRepository.getById(id);
        return voluntarioEmergencia;
    }

    @GetMapping("/emergencia/{id}")
    public Integer cantidadRegistrados(@PathVariable("id") Integer id) {
        Integer salida = voluntarioEmergenciaRepository.cantidadVoluntarios(id);
        return salida;
    }

    @GetMapping("/emergencia/{idEmergencia}/voluntario/{idVoluntario}")
    public Boolean verificarRegistro(@PathVariable("idEmergencia") String emergencia,
                                         @PathVariable("idVoluntario") String voluntario){
        System.out.println("Verificando registro de " + voluntario + "en " + emergencia);
        Integer idEmergencia = Integer.parseInt(emergencia);
        Integer idVoluntario = Integer.parseInt(voluntario);
        Boolean salida = voluntarioEmergenciaRepository.verificarRegistro(idEmergencia, idVoluntario);
        return salida;
    }

    @PostMapping
    public String crearVoluntarioEmergencia(@RequestBody VoluntarioEmergencia voluntarioEmergencia) {
        System.out.println("id_emergencia: " + voluntarioEmergencia.getId_emergencia());
        System.out.println("id_voluntario: " + voluntarioEmergencia.getId_voluntario());
        voluntarioEmergenciaRepository.save(
                voluntarioEmergencia.getId_emergencia(),
                voluntarioEmergencia.getId_voluntario()
        );
        return "Relación creada correctamente";
    }

    @PutMapping("/{id}")
    public Boolean actualizarVoluntarioEmergencia(
            @PathVariable Integer id,
            @RequestBody VoluntarioEmergencia voluntarioEmergencia)
    {
        VoluntarioEmergencia voluntarioEmergenciaExistente = voluntarioEmergenciaRepository.getById(id);
        if (voluntarioEmergenciaExistente != null) {
            voluntarioEmergencia.setIdVoluntarioEmergencia(id);
            voluntarioEmergenciaRepository.save(
                    voluntarioEmergencia.getId_emergencia(),
                    voluntarioEmergencia.getId_voluntario()
            );
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public void eliminarVoluntarioEmergencia(@PathVariable Integer id) {
        VoluntarioEmergencia voluntarioEmergencia = voluntarioEmergenciaRepository.getById(id);
        if (voluntarioEmergencia != null) {
            voluntarioEmergenciaRepository.delete(id);
        }
    }
}
