package com.example.resq.Repository;


import com.example.resq.Models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{
    @Autowired
    private final Sql2o sql2o;

    @Autowired
    public EmergenciaRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Emergencia> getAllEmergencias() {
        String query = "SELECT * FROM Emergencia";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query).executeAndFetch(Emergencia.class);
        }
    }

    @Override
    public Emergencia getEmergenciaById(Integer id) {
        String query = "SELECT * FROM Emergencia WHERE id = :id";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
        }
    }

    @Override
    public void saveEmergencia(Emergencia emergencia) {
        String query = "INSERT INTO Emergencia (nombre, gravedad, fecha, estado, region, longitud, latitud, idInstitucion) " +
                "VALUES (:nombre, :gravedad, :fecha, :estado, :region, :longitud, :latitud, :idInstitucion)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("gravedad", emergencia.getGravedad())
                    .addParameter("fecha", emergencia.getFecha())
                    .addParameter("estado", emergencia.getEstado())
                    .addParameter("region", emergencia.getRegion())
                    .addParameter("longitud", emergencia.getLongitud())
                    .addParameter("latitud", emergencia.getLatitud())
                    .addParameter("idInstitucion", emergencia.getIdInstitucion())
                    .executeUpdate();
        }
    }

    @Override
    public void deleteEmergencia(Integer id) {
        String query = "DELETE FROM Emergencia WHERE id = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public List<Emergencia> getEmergenciasByEstado(String estado) {
        String query = "SELECT * FROM Emergencia WHERE estado = :estado";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query)
                    .addParameter("estado", estado)
                    .executeAndFetch(Emergencia.class);
        }
    }
}
