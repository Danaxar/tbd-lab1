package grupo1.lab1.Repositories;

import grupo1.lab1.Models.TareaHabilidad;

import java.util.List;

public interface TareaHabilidadRepository {
    public List<TareaHabilidad> findAll();
    public TareaHabilidad findById(Integer id);
    public List<TareaHabilidad> findById_eme_Habilidad(Integer id);
    public List<TareaHabilidad> findById_tarea(Integer id_tarea);
    public TareaHabilidad save(TareaHabilidad tareaHabilidad);
    public TareaHabilidad update(TareaHabilidad tareaHabilidad);
    public boolean delete(Integer id);
}
