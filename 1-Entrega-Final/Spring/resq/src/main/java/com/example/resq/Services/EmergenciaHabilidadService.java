package com.example.resq.Services;

import com.example.resq.Models.EmergenciaHabilidad;
import com.example.resq.Repository.EmergenciaHabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergencia-habilidades")
public class EmergenciaHabilidadService {
    private final EmergenciaHabilidadRepository emergenciaHabilidadRepository;
    EmergenciaHabilidadService(EmergenciaHabilidadRepository emergenciaHabilidadRepository){
        this.emergenciaHabilidadRepository = emergenciaHabilidadRepository;
    }

    @GetMapping
    public List<EmergenciaHabilidad> getAllEmergenciaHabilidad() {
        return emergenciaHabilidadRepository.findAll();
    }

    @GetMapping("/{id}")
    public EmergenciaHabilidad findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return emergenciaHabilidadRepository.findById(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/emergencia/{id}")
    public List<EmergenciaHabilidad> findByEmergencia(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return emergenciaHabilidadRepository.findByEmergencia(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/habilidad/{id}")
    public List<EmergenciaHabilidad> findByHabilidad(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return emergenciaHabilidadRepository.findByHabilidad(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @PostMapping
    public EmergenciaHabilidad saveEmergenciaHabilidad(@RequestBody EmergenciaHabilidad emergenciaHabilidad){
        return emergenciaHabilidadRepository.save(emergenciaHabilidad);
    }

    @PutMapping
    public EmergenciaHabilidad updateEmergenciaHabilidad(@RequestBody EmergenciaHabilidad emergenciaHabilidad){
        return emergenciaHabilidadRepository.update(emergenciaHabilidad);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergenciaHabilidad(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            if (emergenciaHabilidadRepository.delete(id)) {System.out.println("fila eliminada con exito");

            }else{
                System.out.println("La fila no fue eliminada");
            }
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
