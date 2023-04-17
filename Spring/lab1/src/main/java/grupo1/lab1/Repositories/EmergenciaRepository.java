package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Emergencia;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface EmergenciaRepository {
    public List<Emergencia> findAll();
    public Emergencia findById(Integer id);
    public List<Emergencia> findByNombre(String nombre);
    public List<Emergencia> findByGravedad(String gravedad);
    public List<Emergencia> findByFecha(String fecha);
    public Emergencia save(Emergencia emergencia);
    public boolean delete(Integer id);
}
