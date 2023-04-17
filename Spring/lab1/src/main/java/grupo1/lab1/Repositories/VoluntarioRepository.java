package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Voluntario;

import java.util.Date;
import java.util.List;

public interface VoluntarioRepository {
    public List<Voluntario> findAll();
    public Voluntario findById(Integer id);
    public List<Voluntario> findByNombre(String nombre);
    public List<Voluntario> findByApellido(String apellido);
    public Voluntario findByTelefono(String telefono);
    public List<Voluntario> findByFechaNacimiento(String fecha_nacimiento);
    public List<Voluntario> findByDisponibilidad(String disponibilidad);
    public List<Voluntario> findByRol(String rol);
    public Voluntario save(Voluntario voluntario);
    public Voluntario update(Voluntario voluntario);
    public boolean delete(Integer id);

    public Voluntario findByRutAndContrasena(String rut, String contrasena);
}
