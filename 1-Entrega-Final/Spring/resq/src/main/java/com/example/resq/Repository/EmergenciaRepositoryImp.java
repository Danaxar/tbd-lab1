package com.example.resq.Repository;


import com.example.resq.Models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Emergencia> getAllEmergencias() {
        List<Emergencia> salida;
        System.out.println("Obteniendo todas las emergencias...");
        String query = "SELECT * FROM Emergencia";
        try (Connection connection = sql2o.open()) {
            salida = connection.createQuery(query).executeAndFetch(Emergencia.class);
            return salida;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Emergencia getEmergenciaById(Integer id) {
        String query = "SELECT * FROM Emergencia WHERE id_emergencia = :id";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
        }
    }

    @Override
    public void saveEmergencia(Emergencia emergencia) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(emergencia.getFecha(), formatoFecha);
        String query = "INSERT INTO Emergencia (nombre, gravedad, fecha, estado, region, longitud, latitud, id_institucion, geom) " +
                "VALUES (:nombre, :gravedad, :fecha, :estado, :region, :longitud, :latitud, :id_institucion, ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')'))";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("gravedad", emergencia.getGravedad())
                    .addParameter("fecha",fecha)
                    .addParameter("estado", emergencia.getEstado())
                    .addParameter("region", emergencia.getRegion())
                    .addParameter("longitud", emergencia.getLongitud())
                    .addParameter("latitud", emergencia.getLatitud())
                    .addParameter("id_institucion", emergencia.getIdInstitucion())
                    .executeUpdate();
        }
    }

    @Override
    public void deleteEmergencia(Integer id) {
        String query = "DELETE FROM Emergencia WHERE id_emergencia = :id";
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
