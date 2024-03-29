package grupo1.lab1.Services;

import grupo1.lab1.Models.EstadoTarea;
import grupo1.lab1.Models.Tarea;
import grupo1.lab1.Repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TareaServices {
    private final TareaRepository tareaRepository;
    TareaServices(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    @GetMapping("/tarea")
    public List<Tarea> getAllTarea() {
        return tareaRepository.findAll();
    }

    @GetMapping("/tarea/{id}")
    public Tarea findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return tareaRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/tarea/nombre/{nombre}")
    public List<Tarea> findByNombre(@PathVariable("nombre") String nombre){
        try {
            return tareaRepository.findByNombre(nombre);
        }catch(Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @GetMapping("/tarea/emergencia/{id}")
    public List<Tarea> findByEmergencia(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return tareaRepository.findByEmergencia(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @PostMapping("/tarea")
    @ResponseBody
    public Tarea save(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }

    @PutMapping("/tarea")
    @ResponseBody
    public Tarea update(@RequestBody Tarea tarea){ return tareaRepository.update(tarea); }


    @DeleteMapping("/tarea/{id}")
    public void delete(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            if (tareaRepository.delete(id)) {System.out.println("Tarea eliminada con exito");

            }else{
                System.out.println("La tarea no fue eliminada");
            }
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
