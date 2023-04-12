package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EmeHabilidad;
import grupo1.lab1.Models.Voluntario;
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
        String query = "SELECT * FROM vol_habilidad";
        try (Connection conn = sql2o.open()) {
            voluntariosHabilidades = conn.createQuery(query).executeAndFetch(VoluntarioHabilidad.class);
            return voluntariosHabilidades;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public VoluntarioHabilidad findById(Integer id) {
        VoluntarioHabilidad voluntarioHabilidad;
        String query = "SELECT * FROM vol_habilidad WHERE id_vol_habilidad = :id";
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
    public List<VoluntarioHabilidad> findById_Habilidad(Integer id_habilidad) {
        List<VoluntarioHabilidad> encontrada;
        String query = "SELECT * FROM vol_habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id_habilidad", id_habilidad)
                    .executeAndFetch(VoluntarioHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<VoluntarioHabilidad> findById_Voluntario(Integer id_voluntario) {
        List<VoluntarioHabilidad> encontrada;
        String query = "SELECT * FROM Vol_habilidad WHERE id_voluntario = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id_voluntario)
                    .executeAndFetch(VoluntarioHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public VoluntarioHabilidad save(VoluntarioHabilidad VoluntarioHabilidad){
        String query = "INSERT INTO vol_habilidad (id_voluntario, id_habilidad) VALUES (:id_voluntario, :id_habilidad)";
        try (Connection conn = sql2o.open()) {
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("id_voluntario", VoluntarioHabilidad.getId_Voluntario())
                    .addParameter("id_habilidad", VoluntarioHabilidad.getId_Habilidad())
                    .executeUpdate()
                    .getKey();
            VoluntarioHabilidad.setId_vol_habilidad(id);
            return VoluntarioHabilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM vol_habilidad WHERE id_vol_habilidad = :id";
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
