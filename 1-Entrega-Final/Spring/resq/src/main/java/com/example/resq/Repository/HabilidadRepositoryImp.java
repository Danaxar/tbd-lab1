package com.example.resq.Repository;

import com.example.resq.Models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Habilidad> findAll() {
        List<Habilidad> habilidades;
        String query = "SELECT * FROM Habilidad";
        try (Connection conn = sql2o.open()) {
            habilidades = conn.createQuery(query).executeAndFetch(Habilidad.class);
            return habilidades;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public Habilidad findById(Integer id) {
        Habilidad habilidad;
        String query = "SELECT * FROM Habilidad WHERE id_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            habilidad = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
            return habilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public Habilidad save(Habilidad habilidad) {
        String query = "INSERT INTO Habilidad (nombre) VALUES (:nombre)";
        try (Connection conn = sql2o.open()) {
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("nombre", habilidad.getNombre())
                    .executeUpdate()
                    .getKey();
            habilidad.setId_habilidad(id);
            return habilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Habilidad update(Habilidad habilidad){
        String query = "UPDATE Habilidad SET nombre = :nombre WHERE id_habilidad = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("nombre", habilidad.getNombre())
                    .addParameter("id", habilidad.getId_habilidad())
                    .executeUpdate();
            return habilidad;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;

    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM Habilidad WHERE id_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
