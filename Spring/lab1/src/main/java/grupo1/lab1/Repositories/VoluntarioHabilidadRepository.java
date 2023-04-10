package grupo1.lab1.Repositories;

import grupo1.lab1.Models.VoluntarioHabilidad;

import java.util.List;

public interface VoluntarioHabilidadRepository {
    public List<VoluntarioHabilidad> findAll();
    public VoluntarioHabilidad findById(Integer id);
    public VoluntarioHabilidad save(VoluntarioHabilidad voluntarioHabilidad);
    public void delete(Integer id);
}
