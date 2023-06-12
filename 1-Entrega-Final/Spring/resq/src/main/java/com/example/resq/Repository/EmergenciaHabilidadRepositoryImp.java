package com.example.resq.Repository;

import com.example.resq.Models.EmergenciaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaHabilidadRepositoryImp implements EmergenciaHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<EmergenciaHabilidad> findAll() {
        String query = "SELECT * FROM emergencia_habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(EmergenciaHabilidad.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmergenciaHabilidad findById(Integer id) {
        EmergenciaHabilidad encontrada;
        String query = "SELECT * FROM emergencia_habilidad WHERE id_emergencia_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergenciaHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<EmergenciaHabilidad> findByEmergencia(Integer id) {
        List<EmergenciaHabilidad> encontrada;
        String query = "SELECT * FROM emergencia_habilidad WHERE id_emergencia = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(EmergenciaHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<EmergenciaHabilidad> findByHabilidad(Integer id) {
        List<EmergenciaHabilidad> encontrada;
        String query = "SELECT * FROM emergencia_habilidad WHERE id_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(EmergenciaHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmergenciaHabilidad save(EmergenciaHabilidad emeHabilidad){
        String query = "INSERT INTO emergencia_habilidad (id_emergencia, id_habilidad) VALUES (:id_emergencia, :id_habilidad)";
        try(Connection conn = sql2o.open()){
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("id_emergencia", emeHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emeHabilidad.getId_habilidad())
                    .executeUpdate()
                    .getKey();
            emeHabilidad.setId(id);
            return emeHabilidad;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmergenciaHabilidad update(EmergenciaHabilidad emergenciaHabilidad){
        String query = "UPDATE emergencia_Habilidad SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad WHERE id_emergencia_habilidad = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("id_emergencia", emergenciaHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergenciaHabilidad.getId_habilidad())
                    .addParameter("id", emergenciaHabilidad.getId())
                    .executeUpdate();
            return emergenciaHabilidad;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;

    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM emergencia_habilidad WHERE id_emergencia_habilidad = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
