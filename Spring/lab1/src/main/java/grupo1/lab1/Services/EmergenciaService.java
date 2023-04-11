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
    public Emergencia findByNombre(@PathVariable("nombre") String nombre){
        try{
            return emergenciaRepository.findByNombre(nombre);
        }catch (Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @GetMapping("/emergencia/gravedad/{gravedad}")
    public Emergencia findByGravedad(@PathParam("gravedad") String gravedad){
        try{
            return emergenciaRepository.findByGravedad(gravedad);
        }catch (Exception e){
            System.out.println("Ingrese una gravedad valida");
            return null;
        }
    }

    @GetMapping("/emergencia/fecha/{fecha}")
    public Emergencia findByFecha(@PathParam("fecha") Date fecha){
        try{
            return emergenciaRepository.findByFecha(fecha);
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
    public void delete(@PathParam("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            emergenciaRepository.delete(id);
        }catch (Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
