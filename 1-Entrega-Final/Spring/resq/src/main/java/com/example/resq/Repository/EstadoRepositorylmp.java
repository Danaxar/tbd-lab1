package com.example.resq.Repository;

import com.example.resq.Models.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EstadoRepositorylmp implements EstadoRepository{
    @Autowired
    private Sql2o sql2o;

    @Autowired
    public EstadoRepositorylmp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Estado> findAllEstado() {
        List<Estado> estados;
        String query = "SELECT * FROM Estado";
        try (Connection conn = sql2o.open()) {
            estados = conn.createQuery(query).executeAndFetch(Estado.class);
            return estados;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Estado findByIdEstado(Integer id) {
        Estado encontrada;
        String query = "SELECT * FROM Estado WHERE id_estado = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Estado.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Estado> findByNombreEstado(String nombre) {
        List<Estado> estados;
        String query = "SELECT * FROM Estado WHERE nombre = :nombre";
        try (Connection con = sql2o.open()) {
            estados = con.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetch(Estado.class);
            return estados;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Integer getIdEstado(String nombre) {
        String query = "SELECT id_estado FROM Estado WHERE nombre = :nombre";
        try (Connection con = sql2o.open()) {
            String id = con.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(String.class);
            return Integer.parseInt(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Estado saveEstado(Estado estado) {
        String query = "INSERT INTO Estado (nombre_estado) " +
                "VALUES (:nombre)";
        try (Connection conn = sql2o.open()) {
            Integer id = (Integer) conn.createQuery(query, true)
                    .addParameter("nombre", estado.getNombre())
                    .executeUpdate().getKey();
            estado.setIdEstado(id);
            return estado;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Estado updateEstado(Estado estado) {
        String query = "UPDATE Estado SET nombre_estado = :nombre " +
                "WHERE id_estado = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("nombre", estado.getNombre())
                    .addParameter("id", estado.getIdEstado())
                    .executeUpdate();
            return estado;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void deleteEstado(Integer id) {
        String query = "DELETE FROM Estado WHERE id_estado = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
