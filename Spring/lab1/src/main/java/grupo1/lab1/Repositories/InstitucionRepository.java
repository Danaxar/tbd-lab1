package grupo1.lab1.Repositories;

import java.util.List;
import grupo1.lab1.Models.Institucion;

public interface InstitucionRepository {

    public Institucion findById(Integer id);
    public List<Institucion> findAll();
    public Institucion save(Institucion institucion);
    public void delete(Integer id);
    public Institucion findByNombre(String nombre);
}
