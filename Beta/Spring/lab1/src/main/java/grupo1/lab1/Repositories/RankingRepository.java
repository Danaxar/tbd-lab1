package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Ranking;
import java.util.List;

public interface RankingRepository {
    public List<Ranking> findAll();
    public Ranking findById(Integer id);
    public List<Ranking> findByVoluntario(Integer id_voluntario);
    public List<Ranking> findByTarea(Integer id_tarea);
    public List<Ranking> findByPuntaje(Integer puntaje);
    public Ranking save(Ranking ranking);

    public Ranking update(Ranking ranking);
    public boolean delete(Integer id);
}
