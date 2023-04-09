package grupo1.lab1.Services;

import grupo1.lab1.Models.Institucion;
import grupo1.lab1.Repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institucion")
public class InstitucionService {

    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/{id}")
    Institucion findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return institucionRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }

    }

}
