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
    public List<Voluntario> findByNombre(@PathVariable("nombre") String nombre){
        try {
            return voluntarioRepository.findByNombre(nombre);
        }catch(Exception e){
            System.out.println("Ingrese un nombre valido");
            return null;
        }
    }

    @GetMapping("/voluntario/apellido/{apellido}")
    public List<Voluntario> findByApellido(@PathVariable("apellido") String apellido){
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

    @GetMapping("/voluntario/FechaNacimiento/{fechaNacimiento}")
    public List<Voluntario> findByFechaNacimiento(@PathVariable("fechaNacimiento") String fechaNacimiento){
        try{
            return voluntarioRepository.findByFechaNacimiento(fechaNacimiento);
        }catch(Exception e){
            System.out.println("Ingrese una fecha de nacimiento valida");
            return null;
        }
    }

    @GetMapping("/voluntario/Disponibilidad/{disponibilidad}")
    public List<Voluntario> findByDisponibilidad(@PathVariable("disponibilidad") String disponibilidad){
        try{
            return voluntarioRepository.findByDisponibilidad(disponibilidad);
        }catch(Exception e){
            System.out.println("Ingrese una disponibilidad valida");
            return null;
        }
    }

    @GetMapping("/voluntario/Rol/{rol}")
    public List<Voluntario> findByRol(@PathVariable("rol") String rol){
        try{
            return voluntarioRepository.findByRol(rol);
        }catch(Exception e){
            System.out.println("Ingrese un rol valido");
            return null;
        }
    }

    @PostMapping("/voluntario")
    @ResponseBody
    public Voluntario save(@RequestBody Voluntario voluntario){
        return voluntarioRepository.save(voluntario);
    }

    @PutMapping("/voluntario")
    @ResponseBody
    public Voluntario update(@RequestBody Voluntario voluntario){
        return voluntarioRepository.update(voluntario);
    }

    @GetMapping("/voluntario/{rut}/{pass}")
    public Voluntario findByRutAndContrasena(@PathVariable("rut") String rut, @PathVariable("pass") String pass){
        return voluntarioRepository.findByRutAndContrasena(rut, pass);
    }

    @DeleteMapping("/voluntario/{id}")
    public void deleteVoluntario(@PathVariable("id") String id_str){
        Integer id;
        try{
            id = Integer.parseInt(id_str);
            if (voluntarioRepository.delete(id)) {System.out.println("Voluntario eliminado con exito");

            }else{
                System.out.println("el voluntario no fue eliminado");
            }

        }catch(Exception e){
            System.out.println("Ingrese un id valido");
        }
    }
}
