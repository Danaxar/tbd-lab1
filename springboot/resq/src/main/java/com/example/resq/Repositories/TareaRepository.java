package com.example.resq.Repositories;

import com.example.resq.Entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Tarea (nombre, descripcion, region, longitud, latitud, geom, id_estado, id_emergencia) " +
            "VALUES (:nombre, :descripcion, :region, :longitud, :latitud, ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')'), :id_estado, :id_emergencia)", nativeQuery = true)
    void crearTarea(@Param("nombre") String nombre, @Param("descripcion") String descripcion,
                    @Param("region") String region, @Param("longitud") Double longitud,
                    @Param("latitud") Double latitud, @Param("id_estado") Integer id_estado, @Param("id_emergencia") Integer id_emergencia);
}
