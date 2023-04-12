package grupo1.lab1.Services;

import grupo1.lab1.Models.Habilidad;
import grupo1.lab1.Repositories.HabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;
    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    @GetMapping("/habilidad")
    public List<Habilidad> getAllHabilidad() {
        return habilidadRepository.findAll();
    }

    @GetMapping("/habilidad/{id}")
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
    @GetMapping("/habilidad/nombre/{nombre}")
    public Habilidad findByNombre(@PathVariable("nombre") String nombre){
        try {
            return habilidadRepository.findByNombre(nombre);
        }catch(Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @PostMapping("/habilidad")
    @ResponseBody
    public Habilidad save(@RequestBody Habilidad habilidad){
        return habilidadRepository.save(habilidad);
    }

    @PutMapping("/habilidad")
    @ResponseBody
    public Habilidad update(@RequestBody Habilidad habilidad){
        return habilidadRepository.update(habilidad);
    }


    @DeleteMapping("/habilidad/{id}")
    public void delete(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            habilidadRepository.delete(id);
            System.out.println("Habilidad Borrada con exito");
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
