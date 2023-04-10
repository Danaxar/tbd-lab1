package grupo1.lab1.Repositories;

import grupo1.lab1.Models.TareaHabilidad;

import java.util.List;

public interface TareaHabilidadRepository {
    public List<TareaHabilidad> findAll();
    public TareaHabilidad findById(Integer id);
    public TareaHabilidad save(TareaHabilidad tareaHabilidad);
    public void delete(Integer id);
}
