package com.example.resq.Repository;
import com.example.resq.Models.Institucion;

import java.util.List;

public interface InstitucionRepository {


    List<Institucion> findAllInstitucion();
    Institucion findByIdInstitucion(Integer id);
    Institucion saveInstitucion(Institucion institucion);

    Institucion updateInstitucion(Institucion institucion);

    void deleteInstitucion(Integer id);

}





