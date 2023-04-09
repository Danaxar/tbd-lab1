package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Tarea;

import java.util.List;

public interface TareaRepository {
    public List<Tarea> findAll();
    public Tarea findById(Integer id);
    public Tarea findByNombre(String nombre);
    public Tarea findByEmergencia(Integer id_emergencia);
    public Tarea save(Tarea tarea);
    public void delete(Integer id);
}
