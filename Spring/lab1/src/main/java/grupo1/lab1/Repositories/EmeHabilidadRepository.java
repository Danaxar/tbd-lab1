package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EmeHabilidad;

import java.util.List;

public interface EmeHabilidadRepository {
    public List<EmeHabilidad> findAll();
    public EmeHabilidad findById(Integer id);
    public EmeHabilidad findByHabilidad(Integer id_habilidad);
    public EmeHabilidad findByEmergencia(Integer id_emergencia);
    public EmeHabilidad save(EmeHabilidad emeHabilidad);
    public void delete(Integer id);
}
