package grupo1.lab1.Services;

import grupo1.lab1.Models.Emergencia;
import grupo1.lab1.Repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencia")
    public List<Emergencia> getAllEmergencia() {
        System.out.println("Ejectando esto");
        return emergenciaRepository.findAll();
    }

    @GetMapping("/emergencia/{id}")
    public Emergencia findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return emergenciaRepository.findById(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/emergencia/nombre/{nombre}")
    public List<Emergencia> findByNombre(@PathVariable("nombre") String nombre){
        try{
            return emergenciaRepository.findByNombre(nombre);
        }catch (Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @GetMapping("/emergencia/gravedad/{gravedad}")
    public List<Emergencia> findByGravedad(@PathVariable("gravedad") String gravedad){
        try{
            return emergenciaRepository.findByGravedad(gravedad);
        }catch (Exception e){
            System.out.println("Ingrese una gravedad valida");
            return null;
        }
    }

    @GetMapping("/emergencia/fecha/{fecha_emergencia}")
    public List<Emergencia> findByFecha(@PathVariable("fecha_emergencia") String fecha_emergencia){
        try{
            return emergenciaRepository.findByFecha(fecha_emergencia);
        }catch (Exception e){
            System.out.println("Ingrese una fecha valida");
            return null;
        }
    }

    @PostMapping("/emergencia")
    public Emergencia save(@RequestBody Emergencia emergencia){
        System.out.println(
                emergencia.getId() + " " +
                emergencia.getNombre() + " " +
                emergencia.getGravedad() + " "
        );
        return emergenciaRepository.save(emergencia);
    }

    @DeleteMapping("/emergencia/{id}")
    public void delete(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            if (emergenciaRepository.delete(id)) {System.out.println("Estado eliminado con exito");

            }else{
                System.out.println("el estado no fue eliminado");
            }
        }catch (Exception e){
            System.out.println(id_str);
            System.out.println(e);
            System.out.println("Ingrese un id valido");
        }
    }
}
