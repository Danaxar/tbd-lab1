package com.example.resq.Repository;

import com.example.resq.Models.Ranking;
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
        String query = "SELECT * FROM ranking";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking findById(Integer id) {
        Ranking encontrada;
        String query = "SELECT * FROM ranking WHERE id_ranking = :id";
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
    public List<Ranking> findByVoluntario(Integer id_voluntario) {
        List<Ranking> encontrada;
        String query = "SELECT * FROM ranking WHERE id_voluntario = :id_voluntario";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetch(Ranking.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Ranking> findByTarea(Integer id_tarea) {
        List<Ranking> encontrada;
        String query = "SELECT * FROM ranking WHERE id_tarea = :id_tarea";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Ranking.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ranking save(Ranking ranking) {
        String query = "INSERT INTO ranking (id_voluntario, id_tarea) VALUES (:id_voluntario, :id_tarea)";
        try (Connection conn = sql2o.open()) {
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
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
    public Ranking update(Ranking ranking) {
        String query = "UPDATE ranking SET id_voluntario = :id_voluntario, id_tarea = :id_tarea WHERE id_ranking = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query, true)
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("id", ranking.getId())
                    .executeUpdate();
            return ranking;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM ranking WHERE id_ranking = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}

