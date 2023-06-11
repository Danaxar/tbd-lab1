package com.example.resq.Repositories;

import com.example.resq.Entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query(value = "SELECT * FROM Estado e WHERE e.nombre = :nombre", nativeQuery = true)
    Estado getByNombre(@Param("nombre") String nombre);
}
