package grupo1.lab1.Services;

import grupo1.lab1.Models.Emergencia;
import grupo1.lab1.Models.TareaHabilidad;
import grupo1.lab1.Models.VoluntarioHabilidad;
import grupo1.lab1.Repositories.VoluntarioHabilidadRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
public class VoluntarioHabilidadService {
    private final VoluntarioHabilidadRepository voluntarioHabilidadRepository;

    public VoluntarioHabilidadService(VoluntarioHabilidadRepository voluntarioHabilidadRepository) {
        this.voluntarioHabilidadRepository = voluntarioHabilidadRepository;
    }
    @GetMapping("/voluntarioHabilidad")
    public List<VoluntarioHabilidad> getAllVoluntarioHabilidad() {
        return voluntarioHabilidadRepository.findAll();
    }
    @GetMapping("/voluntarioHabilidad/{id}")
    public VoluntarioHabilidad findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return voluntarioHabilidadRepository.findById(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/voluntarioHabilidad/id_habilidad/{id_habilidad}")
    public List<VoluntarioHabilidad> findById_Habilidad(@PathVariable("id_habilidad") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return voluntarioHabilidadRepository.findById_Habilidad(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
        return null;
    }

    @GetMapping("/voluntarioHabilidad/id_voluntario/{id_voluntario}")
    public List<VoluntarioHabilidad> findById_Voluntario(@PathVariable("id_voluntario") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return voluntarioHabilidadRepository.findById_Voluntario(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
        return null;
    }

    @PostMapping("/voluntarioHabilidad")
    @ResponseBody
    public VoluntarioHabilidad createVoluntarioHabilidad(@RequestBody VoluntarioHabilidad voluntarioHabilidad){
        return voluntarioHabilidadRepository.save(voluntarioHabilidad);
    }

    @DeleteMapping("/voluntarioHabilidad/{id}")
    public void deleteVoluntarioHabilidad(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);

            if (voluntarioHabilidadRepository.delete(id)) {System.out.println("Fila eliminada con exito");

            }else{
                System.out.println("La fila no fue eliminada");
            }

        }catch (Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
