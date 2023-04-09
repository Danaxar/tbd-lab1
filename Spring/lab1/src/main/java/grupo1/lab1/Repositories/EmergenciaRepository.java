package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Emergencia;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface EmergenciaRepository {
    public List<Emergencia> findAll();
    public Emergencia findById(Integer id);
    public Emergencia findByNombre(String nombre);
    public Emergencia findByGravedad(String gravedad);
    public Emergencia findByFecha(Date fecha);
    public Emergencia save(Emergencia emergencia);
    public void delete(Integer id);
}
