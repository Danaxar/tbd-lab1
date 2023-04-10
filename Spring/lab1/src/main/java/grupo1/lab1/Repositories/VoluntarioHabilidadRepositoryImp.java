package grupo1.lab1.Repositories;

import grupo1.lab1.Models.VoluntarioHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioHabilidadRepositoryImp implements VoluntarioHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<VoluntarioHabilidad> findAll() {
        List<VoluntarioHabilidad> voluntariosHabilidades;
        String query = "SELECT * FROM VoluntarioHabilidad";
        try (Connection conn = sql2o.open()) {
            voluntariosHabilidades = conn.createQuery(query).setAutoDeriveColumnNames(true).executeAndFetch(VoluntarioHabilidad.class);
            return voluntariosHabilidades;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public VoluntarioHabilidad findById(Integer id) {
        VoluntarioHabilidad voluntarioHabilidad;
        String query = "SELECT * FROM VoluntarioHabilidad WHERE id_voluntario_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            voluntarioHabilidad = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioHabilidad.class);
            return voluntarioHabilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public VoluntarioHabilidad save(VoluntarioHabilidad VoluntarioHabilidad){
        String query = "INSERT INTO VoluntarioHabilidad (id_voluntario_habilidad) VALUES (:id_voluntario_habilidad)";
        try (Connection conn = sql2o.open()) {
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("id_voluntario_habilidad", VoluntarioHabilidad.getId_voluntario_habilidad())
                    .executeUpdate()
                    .getKey();
            VoluntarioHabilidad.setId_voluntario_habilidad(id);
            return VoluntarioHabilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM VoluntarioHabilidad WHERE id_voluntario_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
