package grupo1.lab1.Services;

import grupo1.lab1.Models.Voluntario;
import grupo1.lab1.Repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;
    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/voluntario")
    public List<Voluntario> getAllVoluntario() {
        return voluntarioRepository.findAll();
    }

    @GetMapping("/voluntario/{id}")
    public Voluntario findById(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            return voluntarioRepository.findById(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
            return null;
        }
    }

    @GetMapping("/voluntario/nombre/{nombre}")
    public Voluntario findByNombre(@PathVariable("nombre") String nombre){
        try {
            return voluntarioRepository.findByNombre(nombre);
        }catch(Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @GetMapping("/voluntario/apellido/{apellido}")
    public Voluntario findByApellido(@PathVariable("apellido") String apellido){
        try {
            return voluntarioRepository.findByApellido(apellido);
        }catch(Exception e){
            System.out.println("Ingrese un apellido valido");
            return null;
        }
    }

    @GetMapping("/voluntario/Telefono/{telefono}")
    public Voluntario findByTelefono(@PathVariable("telefono") String telefono){
        try{
            return voluntarioRepository.findByTelefono(telefono);
        }catch(Exception e){
            System.out.println("Ingrese un telefono valido");
            return null;
        }
    }

    @GetMapping("/voluntario/Contrasena/{contrasena}")
    public Voluntario findByContrasena(@PathVariable("contrasena") String contrasena){
        try{
            return voluntarioRepository.findByContrasena(contrasena);
        }catch(Exception e){
            System.out.println("Ingrese una contrasena valida");
            return null;
        }
    }

    @GetMapping("/voluntario/FechaNacimiento/{fechaNacimiento}")
    public Voluntario findByFechaNacimiento(@PathVariable("fechaNacimiento") Date fechaNacimiento){
        try{
            return voluntarioRepository.findByFechaNacimiento(fechaNacimiento);
        }catch(Exception e){
            System.out.println("Ingrese una fecha de nacimiento valida");
            return null;
        }
    }

    @GetMapping("/voluntario/Disponibilidad/{disponibilidad}")
    public Voluntario findByDisponibilidad(@PathVariable("disponibilidad") String disponibilidad){
        try{
            return voluntarioRepository.findByDisponibilidad(disponibilidad);
        }catch(Exception e){
            System.out.println("Ingrese una disponibilidad valida");
            return null;
        }
    }

    @PostMapping("/voluntario")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        return voluntarioRepository.save(voluntario);
    }

    @DeleteMapping("/voluntario/{id}")
    public void deleteVoluntario(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            voluntarioRepository.delete(id);
        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
