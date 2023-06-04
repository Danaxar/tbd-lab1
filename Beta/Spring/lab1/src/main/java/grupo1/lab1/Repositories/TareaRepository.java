package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Tarea;

import java.util.List;

public interface TareaRepository {
    public List<Tarea> findAll();
    public Tarea findById(Integer id);
    public List<Tarea> findByNombre(String nombre);
    public List<Tarea> findByEmergencia(Integer id_emergencia);
    public Tarea save(Tarea tarea);
    public Tarea update(Tarea tarea);
    public boolean delete(Integer id);
}
