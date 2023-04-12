package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EstadoTarea;
import java.util.List;

public interface EstadoTareaRepository {
    public List<EstadoTarea> findAll();
    public EstadoTarea findById(Integer id);
    public List<EstadoTarea> findByNombre(String nombre);
    public EstadoTarea save(EstadoTarea estadoTarea);

    public EstadoTarea update(EstadoTarea estadoTarea);
    public void delete(Integer id);
}
