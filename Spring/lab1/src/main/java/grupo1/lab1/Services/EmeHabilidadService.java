package grupo1.lab1.Services;

import grupo1.lab1.Models.EmeHabilidad;
import grupo1.lab1.Models.Emergencia;
import grupo1.lab1.Repositories.EmeHabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmeHabilidadService {
    private final EmeHabilidadRepository emeHabilidadRepository;
    EmeHabilidadService(EmeHabilidadRepository emeHabilidadRepository){
        this.emeHabilidadRepository = emeHabilidadRepository;
    }

    @GetMapping("/emehabilidad")
    public List<EmeHabilidad> getAllEmeHabilidad() {
        return emeHabilidadRepository.findAll();
    }

    @GetMapping("/emehabilidad/{id}")
    public EmeHabilidad findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return emeHabilidadRepository.findById(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/emehabilidad/emergencia/{id}")
    public List<EmeHabilidad> findByEmergencia(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return emeHabilidadRepository.findByEmergencia(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/emehabilidad/habilidad/{id}")
    public List<EmeHabilidad> findByHabilidad(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return emeHabilidadRepository.findByHabilidad(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @PostMapping("/emehabilidad")
    @ResponseBody
    public EmeHabilidad saveEmeHabilidad(@RequestBody EmeHabilidad emeHabilidad){
        return emeHabilidadRepository.save(emeHabilidad);
    }

    @DeleteMapping("/emehabilidad/{id}")
    public void deleteEmeHabilidad(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            if (emeHabilidadRepository.delete(id)) {System.out.println("fila eliminada con exito");

            }else{
                System.out.println("La fila no fue eliminada");
            }
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
