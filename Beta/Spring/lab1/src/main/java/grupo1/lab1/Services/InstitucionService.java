package grupo1.lab1.Services;

import grupo1.lab1.Models.EstadoTarea;
import grupo1.lab1.Models.Institucion;
import grupo1.lab1.Repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class InstitucionService {

    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/institucion")
    public List<Institucion> getAllInstitucion(){
        return institucionRepository.findAll();
    }

    @GetMapping("/institucion/{id}")
    public Institucion findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return institucionRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }

    }

    @GetMapping("/institucion/nombre/{nombre}")
    public List<Institucion> findByNombre(@PathVariable("nombre") String nombre){
        try{
            return institucionRepository.findByNombre(nombre);
        } catch (Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @PostMapping("/institucion")
    @ResponseBody
    public Institucion save(@RequestBody Institucion institucion){
        return institucionRepository.save(institucion);
    }

    @PutMapping("/institucion")
    @ResponseBody
    public Institucion update(@RequestBody Institucion institucion){ return institucionRepository.update(institucion); }

    @DeleteMapping("/institucion/{id}")
    public void delete(@PathVariable("id") String id_str){
        int id;
        try{
            id = Integer.parseInt(id_str);

            if (institucionRepository.delete(id)) {System.out.println("institucion eliminada con exito");

            }else{
                System.out.println("la institucion no fue eliminada");
            }
        } catch (Exception e){
            System.out.println("Ingrese un id valido");
        }
    }


}
