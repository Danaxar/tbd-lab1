package grupo1.lab1.Services;

import grupo1.lab1.Models.Tarea;
import grupo1.lab1.Models.TareaHabilidad;
import grupo1.lab1.Repositories.TareaHabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TareaHabilidadService {
    private final TareaHabilidadRepository tareaHabilidadRepository;
    TareaHabilidadService(TareaHabilidadRepository tareaHabilidadRepository){
        this.tareaHabilidadRepository = tareaHabilidadRepository;
    }
    @GetMapping("/tareaHabilidad")
    public List<TareaHabilidad> getAllTareaHabilidad() {
        return tareaHabilidadRepository.findAll();
    }

    @GetMapping("/tareaHabilidad/{id}")
    public TareaHabilidad findById(@PathVariable("id") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            return tareaHabilidadRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
        return null;
    }
    @PostMapping("/tareaHabilidad")
    @ResponseBody
    public TareaHabilidad createTareaHabilidad(@RequestBody TareaHabilidad tareaHabilidad){
        return tareaHabilidadRepository.save(tareaHabilidad);
    }
    @DeleteMapping("/tareaHabilidad/{id}")
    public void deleteTareaHabilidad(@PathVariable("id") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            tareaHabilidadRepository.delete(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
