package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> findAll() {
        List<Ranking> salida;
        String query = "SELECT * FROM Ranking";
        try (Connection conn = sql2o.open()) {
            salida = conn.createQuery(query).setAutoDeriveColumnNames(true).executeAndFetch(Ranking.class);
            return salida;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking findById(Integer id) {
        Ranking encontrada;
        String query = "SELECT * FROM Ranking WHERE id_ranking = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking findByNombre(String nombre) {
        Ranking encontrada;
        String query = "SELECT * FROM Ranking WHERE nombre = :nombre";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Ranking.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking findByPuntaje(Integer puntaje) {
        Ranking encontrada;
        String query = "SELECT * FROM Ranking WHERE puntaje_ranking = :puntaje";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("puntaje", puntaje)
                    .executeAndFetchFirst(Ranking.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking findByVoluntario(Integer id_voluntario) {
        Ranking encontrada;
        String query = "SELECT * FROM Ranking WHERE id_voluntario = :id_voluntario";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetchFirst(Ranking.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking findByTarea(Integer id_tarea) {
        Ranking encontrada;
        String query = "SELECT * FROM Ranking WHERE id_tarea = :id_tarea";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetchFirst(Ranking.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking save(Ranking ranking) {
        String sql = "INSERT INTO ranking (nombre, puntaje_ranking, id_voluntario, id_tarea) VALUES (:nombre, :puntaje_ranking, :id_voluntario, :id_tarea)";
        try (Connection con = sql2o.open()) {
            Integer id = (int) con.createQuery(sql, true)
                    .bind(ranking)
                    .executeUpdate()
                    .getKey();
            ranking.setId(id);
            return ranking;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM ranking WHERE id_ranking = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
