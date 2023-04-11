package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Voluntario;

import java.util.Date;
import java.util.List;

public interface VoluntarioRepository {
    public Voluntario findById(Integer id);
    public Voluntario findByNombre(String nombre);
    public Voluntario findByApellido(String apellido);
    public Voluntario findByTelefono(String telefono);
    public Voluntario findByContrasena(String contrasena);
    public Voluntario findByFechaNacimiento(Date fecha_nacimiento);
    public Voluntario findByDisponibilidad(String disponibilidad);
    public List<Voluntario> findAll();
    public Voluntario save(Voluntario voluntario);
    public void delete(Integer id);

    public Voluntario findByRutAndContrasena(String rut, String contrasena);
}
