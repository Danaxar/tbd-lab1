package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Ranking;
import java.util.List;

public interface RankingRepository {
    public List<Ranking> findAll();
    public Ranking findById(Integer id);
    public Ranking findByNombre(String nombre);
    public Ranking findByVoluntario(Integer id_voluntario);
    public Ranking findByTarea(Integer id_tarea);
    public Ranking findByPuntaje(Integer puntaje);
    public Ranking save(Ranking ranking);
    public void delete(Integer id);
}
