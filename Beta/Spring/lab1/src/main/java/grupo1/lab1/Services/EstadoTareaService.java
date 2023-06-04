package grupo1.lab1.Services;

import grupo1.lab1.Models.EstadoTarea;
import grupo1.lab1.Repositories.EstadoTareaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EstadoTareaService {
    private final EstadoTareaRepository estadoTareaRepository;
    EstadoTareaService(EstadoTareaRepository estadoTareaRepository){
        this.estadoTareaRepository = estadoTareaRepository;
    }

    @GetMapping("/estadoTarea")
    public List<EstadoTarea> getAllEstadoTarea(){
        return estadoTareaRepository.findAll();
    }

    @GetMapping("/estadoTarea/{id}")
    public EstadoTarea findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return estadoTareaRepository.findById(id);
        } catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }
    @GetMapping("/estadoTarea/nombre/{nombre}")
    public List<EstadoTarea> findByNombre(@PathVariable("nombre") String nombre){
        try{
            return estadoTareaRepository.findByNombre(nombre);
        } catch (Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }
    @PostMapping("/estadoTarea")
    @ResponseBody
    public EstadoTarea save(@RequestBody EstadoTarea estadoTarea){
        return estadoTareaRepository.save(estadoTarea);
    }


    @PutMapping("/estadoTarea")
    @ResponseBody
    public EstadoTarea update(@RequestBody EstadoTarea estadoTarea){ return estadoTareaRepository.update(estadoTarea); }


    @DeleteMapping("/estadoTarea/{id}")
    public void delete(@PathVariable("id") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);
            if (estadoTareaRepository.delete(id)) {System.out.println("Estado eliminado con exito");

            }else{
                System.out.println("el estado no fue eliminado");
            }
        } catch (Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
