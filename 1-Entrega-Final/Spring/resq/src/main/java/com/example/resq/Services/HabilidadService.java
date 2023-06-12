package com.example.resq.Services;

import com.example.resq.Models.Habilidad;
import com.example.resq.Repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    @Autowired
    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    @GetMapping
    public List<Habilidad> getAllHabilidad() {
        return habilidadRepository.findAll();
    }

    @GetMapping("/{id}")
    public Habilidad findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return habilidadRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @PostMapping
    @ResponseBody
    public Habilidad save(@RequestBody Habilidad habilidad){
        return habilidadRepository.save(habilidad);
    }

    @PutMapping
    @ResponseBody
    public Habilidad update(@RequestBody Habilidad habilidad){
        return habilidadRepository.update(habilidad);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            if (habilidadRepository.delete(id)) {System.out.println("Habilidad eliminada con exito");

            }else{
                System.out.println("la habilidad no fue eliminada");
            }
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
