package com.example.resq.Services;

import com.example.resq.Models.Institucion;
import com.example.resq.Repository.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituciones")
public class InstitucionService {

    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping
    public List<Institucion> getAllInstitucion(){
        return institucionRepository.findAllInstitucion();
    }

    @GetMapping("/{id}")
    public Institucion findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return institucionRepository.findByIdInstitucion(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }

    }

    @PostMapping
    @ResponseBody
    public Institucion save(@RequestBody Institucion institucion){
        return institucionRepository.saveInstitucion(institucion);
    }

    @PutMapping
    @ResponseBody
    public Institucion update(@RequestBody Institucion institucion){ return institucionRepository.updateInstitucion(institucion); }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            institucionRepository.deleteInstitucion(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }


}
