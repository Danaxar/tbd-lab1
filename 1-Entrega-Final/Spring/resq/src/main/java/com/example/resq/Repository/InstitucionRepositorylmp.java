package com.example.resq.Repository;

import com.example.resq.Models.Institucion;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class InstitucionRepositorylmp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    public InstitucionRepositorylmp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Institucion> findAllInstitucion() {
        List<Institucion> institucions;
        String query = "SELECT * FROM Institucion";
        try (org.sql2o.Connection conn = sql2o.open()) {
            institucions = conn.createQuery(query).executeAndFetch(Institucion.class);
            return institucions;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Institucion findByIdInstitucion(Integer id) {
        Institucion encontrada;
        String query = "SELECT * FROM Institucion WHERE id_institucion = :id";
        try (org.sql2o.Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Institucion.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    @Override
    public Institucion saveInstitucion(Institucion institucion) {
        String query = "INSERT INTO institucion (nombre) VALUES (:nombre)";
        try (org.sql2o.Connection conn = sql2o.open()) {
            Integer id = conn.createQuery(query, true)
                    .addParameter("nombre", institucion.getNombre())
                    .executeUpdate().getKey(Integer.class);
            institucion.setId_Institucion(id);
            return institucion;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Institucion updateInstitucion(Institucion institucion) {
        String query = "UPDATE institucion SET nombre = :nombre WHERE id_institucion = :id";
        try (org.sql2o.Connection conn = sql2o.open()) {
            Integer id = conn.createQuery(query, true)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("id", institucion.getId_Institucion())
                    .executeUpdate().getKey(Integer.class);
            institucion.setId_Institucion(id);
            return institucion;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void deleteInstitucion(Integer id) {
        String query = "DELETE FROM institucion WHERE id_institucion = :id";
        try (org.sql2o.Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}