package com.example.resq.Services;

import com.example.resq.Models.Estado;
import com.example.resq.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoService {

    private final EstadoRepository estadoRepository;

    @Autowired
    EstadoService(EstadoRepository estadoRepository){
        this.estadoRepository = estadoRepository;
    }

    @GetMapping
    public List<Estado> getAllEstado(){
        return estadoRepository.findAllEstado();
    }

    @GetMapping("/{id}")
    public Estado findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return estadoRepository.findByIdEstado(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @PostMapping
    @ResponseBody
    public Estado save(@RequestBody Estado estado){
        return estadoRepository.saveEstado(estado);
    }

    @PutMapping
    @ResponseBody
    public Estado update(@RequestBody Estado estado){ return estadoRepository.updateEstado(estado); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            estadoRepository.deleteEstado(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }


}