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
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return tareaHabilidadRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
        return null;
    }

    @GetMapping("/tareaHabilidad/id_eme_habilidad/{id_eme_Habilidad}")
    public List<TareaHabilidad> findById_eme_Habilidad(@PathVariable("id_eme_Habilidad") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            return tareaHabilidadRepository.findById_eme_Habilidad(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
        return null;
    }

    @GetMapping("/tareaHabilidad/id_tarea/{id_tarea}")
    public List<TareaHabilidad> findById_tarea(@PathVariable("id_tarea") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            return tareaHabilidadRepository.findById_tarea(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
        return null;
    }

    @PostMapping("/tareaHabilidad")
    @ResponseBody
    public TareaHabilidad save(@RequestBody TareaHabilidad tareaHabilidad){
        return tareaHabilidadRepository.save(tareaHabilidad);
    }

    @PutMapping("/tareaHabilidad")
    @ResponseBody
    public TareaHabilidad update(@RequestBody TareaHabilidad tareaHabilidad){
        return tareaHabilidadRepository.update(tareaHabilidad);
    }

    @DeleteMapping("/tareaHabilidad/{id}")
    public void deleteTareaHabilidad(@PathVariable("id") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            if (tareaHabilidadRepository.delete(id)) {System.out.println("Fila eliminada con exito");

            }else{
                System.out.println("La fila no fue eliminada");
            }
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
