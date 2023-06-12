package com.example.resq.Repository;

import com.example.resq.Models.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> findAllEstado();
    Estado findByIdEstado(Integer id);
    List<Estado> findByNombreEstado(String nombre);
    Estado saveEstado(Estado estado);
    void deleteEstado(Integer id);
    Estado updateEstado(Estado estado);
}
