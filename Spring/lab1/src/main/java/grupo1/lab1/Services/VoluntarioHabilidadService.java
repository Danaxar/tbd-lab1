package grupo1.lab1.Services;

import grupo1.lab1.Models.Emergencia;
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
            voluntarioHabilidadRepository.delete(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
