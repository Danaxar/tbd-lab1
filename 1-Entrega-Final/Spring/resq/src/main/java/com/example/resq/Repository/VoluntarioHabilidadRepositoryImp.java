package com.example.resq.Repository;

import com.example.resq.Models.VoluntarioHabilidad;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository

public class VoluntarioHabilidadRepositoryImp implements VoluntarioHabilidadRepository {
    private final Sql2o sql2o;

    public VoluntarioHabilidadRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<VoluntarioHabilidad> getAll() {
        String query = "SELECT * FROM voluntario_habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(VoluntarioHabilidad.class);
        }
    }

    @Override
    public VoluntarioHabilidad getById(int id) {
        String query = "SELECT * FROM voluntario_habilidad WHERE id_voluntario_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioHabilidad.class);
        }
    }

    @Override
    public void create(VoluntarioHabilidad voluntarioHabilidad) {
        String query = "INSERT INTO voluntario_habilidad (id_voluntario, id_habilidad) " +
                "VALUES (:idVoluntario, :idHabilidad)";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("idVoluntario", voluntarioHabilidad.getIdVoluntario())
                    .addParameter("idHabilidad", voluntarioHabilidad.getIdHabilidad())
                    .executeUpdate();
        }
    }

    @Override
    public void update(VoluntarioHabilidad voluntarioHabilidad) {
        String query = "UPDATE voluntario_habilidad SET id_voluntario = :idVoluntario, " +
                "id_habilidad = :idHabilidad WHERE id_voluntario_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("idVoluntario", voluntarioHabilidad.getIdVoluntario())
                    .addParameter("idHabilidad", voluntarioHabilidad.getIdHabilidad())
                    .addParameter("id", voluntarioHabilidad.getIdVoluntarioHabilidad())
                    .executeUpdate();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM voluntario_habilidad WHERE id_voluntario_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}