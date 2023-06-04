package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Habilidad;

import java.util.List;

public interface HabilidadRepository {
    public List<Habilidad> findAll();
    public Habilidad findById(Integer id);
    public Habilidad findByNombre(String nombre);
    public Habilidad save(Habilidad habilidad);
    public Habilidad update(Habilidad habilidad);
    public boolean delete(Integer id);
}
