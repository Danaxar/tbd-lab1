package com.example.resq.Repositories;

import ch.qos.logback.core.spi.LogbackLock;
import com.example.resq.Entities.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;


@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
    Optional<Voluntario> findFirstByRut(String rut);

    @Modifying
    @Query(value = "INSERT INTO Voluntario (rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) " +
            "VALUES (:rut, :nombres, :apellidos, :fecha_nac, :disponibilidad, :telefono, :rol, :contrasena, :region, :longitud, :latitud, ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')'))", nativeQuery = true)
    void crearVoluntario(@Param("rut") String rut, @Param("nombres") String nombres, @Param("apellidos") String apellidos,
                         @Param("fecha_nac") Date fecha_nac, @Param("disponibilidad") String disponibilidad,
                         @Param("telefono") String telefono, @Param("rol") String rol, @Param("contrasena") String contrasena,
                         @Param("region") String region, @Param("longitud") Double longitud, @Param("latitud") Double latitud);
}
