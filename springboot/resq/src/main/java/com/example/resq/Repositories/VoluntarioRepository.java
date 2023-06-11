package com.example.resq.Repositories;

import com.example.resq.Entities.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
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

    @Query(value = "SELECT vol.id, vol.rut, vol.nombres, vol.apellidos, vol.fecha_nac, vol.disponibilidad, vol.telefono, vol.rol, vol.contrasena, vol.region, vol.longitud, vol.latitud, vol.geom " +
            "FROM( SELECT (ST_Distance (eme.geom, vol.geom)) AS distancias, vol.id, vol.rut, vol.nombres, vol.apellidos, vol.fecha_nac, vol.disponibilidad, vol.telefono, vol.rol, vol.contrasena, vol.region, vol.longitud, vol.latitud, vol.geom " +
            "FROM emergencia AS eme " +
            "INNER JOIN voluntario_emergencia as volEme ON volEme.id_emergencia = eme.id_emergencia " +
            "INNER JOIN voluntario as vol ON volEme.id_voluntario = vol.id " +
            "WHERE eme.id_emergencia = :id_emergencia " +
            "ORDER BY distancias ASC " +
            "LIMIT :limite" +
            ") AS vol;", nativeQuery = true)
    List<Voluntario> traerVoluntariosCercanos(@Param("id_emergencia") Integer id_emergencia, @Param("limite") Integer limite);

    @Query(value = "SELECT vol.id, vol.rut, vol.nombres, vol.apellidos, vol.fecha_nac, vol.disponibilidad, vol.telefono, vol.rol, vol.contrasena, vol.region, vol.longitud, vol.latitud, vol.geom " +
            "FROM emergencia eme " +
            "INNER JOIN voluntario_emergencia as volEme ON eme.id_emergencia = volEme.id_emergencia " +
            "INNER JOIN voluntario as vol ON vol.id = volEme.id_voluntario " +
            "WHERE eme.id_emergencia = :id_emergencia", nativeQuery = true)
    List<Voluntario> getVoluntariosByEmergencia(@Param("id_emergencia") Integer id_emergencia);
}
