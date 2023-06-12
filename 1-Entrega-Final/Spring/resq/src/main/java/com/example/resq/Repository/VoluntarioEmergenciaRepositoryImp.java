package com.example.resq.Repository;

import com.example.resq.Models.VoluntarioEmergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioEmergenciaRepositoryImp implements VoluntarioEmergenciaRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<VoluntarioEmergencia> getAll(){
        List<VoluntarioEmergencia> salida;
        System.out.println("Obteniendo todas las VoluntarioEmergencia...");
        String query = "SELECT * FROM voluntario_emergencia";
        try (Connection connection = sql2o.open()) {
            salida = connection.createQuery(query).executeAndFetch(VoluntarioEmergencia.class);
            return salida;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public VoluntarioEmergencia getById(Integer id){
        String query = "SELECT * FROM voluntario_emergencia WHERE id_voluntario_emergencia = :id";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioEmergencia.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public void save(Integer id_emergencia, Integer id_voluntario){
        String query = "INSERT INTO voluntario_emergencia (id_voluntario, id_emergencia) " +
                "VALUES (:id_voluntario, :id_emergencia)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("id_voluntario", id_voluntario)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public Boolean delete(Integer id){
        String query = "DELETE FROM voluntario_emergencia WHERE id_emergencia = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        }
        return null;
    }

    public Integer cantidadVoluntarios(Integer id_emergencia){
//        String query = "SELECT id_emergencia, COUNT(*) FROM voluntario_emergencia" +
//                "GROUP BY id_emergencia HAVING id_emergencia = :id_emergencia";
        String query = "SELECT COUNT(*) FROM voluntario_emergencia WHERE id_emergencia = :id_emergencia";

        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetchFirst(Integer.class);
        }
    }

    public Boolean verificarRegistro(Integer id_emergencia, Integer id_voluntario) {
        String query = "SELECT * FROM voluntario_emergencia WHERE id_emergencia = :id_emergencia AND id_voluntario = :id_voluntario";
        try (Connection conn = sql2o.open()) {
            VoluntarioEmergencia salida = conn.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetchFirst(VoluntarioEmergencia.class);
            if (salida != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
