package grupo1.lab1.Repositories;

import grupo1.lab1.Models.VoluntarioHabilidad;

import java.util.List;

public interface VoluntarioHabilidadRepository {
    public List<VoluntarioHabilidad> findAll();
    public VoluntarioHabilidad findById(Integer id);
    public List<VoluntarioHabilidad> findById_Habilidad(Integer id_habilidad);
    public List<VoluntarioHabilidad> findById_Voluntario(Integer id_voluntario);
    public VoluntarioHabilidad save(VoluntarioHabilidad voluntarioHabilidad);
    public boolean delete(Integer id);
}
