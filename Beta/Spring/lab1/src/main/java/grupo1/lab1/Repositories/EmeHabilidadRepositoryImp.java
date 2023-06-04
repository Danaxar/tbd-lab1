package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EmeHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmeHabilidadRepositoryImp implements EmeHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<EmeHabilidad> findAll() {
        String query = "SELECT * FROM Eme_habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(EmeHabilidad.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmeHabilidad findById(Integer id) {
        EmeHabilidad encontrada;
        String query = "SELECT * FROM Eme_habilidad WHERE id_eme_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmeHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<EmeHabilidad> findByEmergencia(Integer id) {
        List<EmeHabilidad> encontrada;
        String query = "SELECT * FROM Eme_habilidad WHERE id_emergencia = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(EmeHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<EmeHabilidad> findByHabilidad(Integer id) {
        List<EmeHabilidad> encontrada;
        String query = "SELECT * FROM Eme_habilidad WHERE id_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(EmeHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public EmeHabilidad save(EmeHabilidad emeHabilidad){
        String query = "INSERT INTO Eme_habilidad (id_emergencia, id_habilidad) VALUES (:id_emergencia, :id_habilidad)";
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
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Eme_habilidad WHERE id_eme_habilidad = :id";
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
