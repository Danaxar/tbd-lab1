package com.example.resq.Repositories;

import com.example.resq.Entities.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Emergencia (nombre, gravedad, fecha, estado, region, longitud, latitud, geom, id_institucion) " +
            "VALUES (:nombre, :gravedad, :fecha, :estado, :region, :longitud, :latitud, ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')'), :id_institucion)", nativeQuery = true)
    void crearEmergencia(@Param("nombre") String nombre, @Param("gravedad") String gravedad, @Param("fecha") LocalDate fecha,
                         @Param("estado") String estado, @Param("region") String region, @Param("longitud") Double longitud,
                         @Param("latitud") Double latitud, @Param("id_institucion") Integer id_institucion);

    List<Emergencia> getEmergenciasByEstado(String estado);
}
