package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EmeHabilidad;

import java.util.List;

public interface EmeHabilidadRepository {
    public List<EmeHabilidad> findAll();
    public EmeHabilidad findById(Integer id);
    public List<EmeHabilidad> findByHabilidad(Integer id_habilidad);
    public List<EmeHabilidad> findByEmergencia(Integer id_emergencia);
    public EmeHabilidad save(EmeHabilidad emeHabilidad);
    public boolean delete(Integer id);
}
