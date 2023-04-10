package grupo1.lab1.Repositories;

import grupo1.lab1.Models.TareaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<TareaHabilidad> findAll() {
        List<TareaHabilidad> salida;
        String query = "SELECT * FROM TareaHabilidad";
        try (Connection conn = sql2o.open()) {
            salida = conn.createQuery(query).setAutoDeriveColumnNames(true).executeAndFetch(TareaHabilidad.class);
            return salida;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public TareaHabilidad findById(Integer id) {
        TareaHabilidad encontrada;
        String query = "SELECT * FROM TareaHabilidad WHERE id_tarea_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaHabilidad.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public TareaHabilidad save(TareaHabilidad tareaHabilidad){
        String query = "INSERT INTO TareaHabilidad (id_tarea_habilidad) VALUES (:id_tarea_habilidad)";
        try(Connection conn = sql2o.open()){
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("id_tarea_habilidad", tareaHabilidad.getId_tarea_habilidad())
                    .executeUpdate()
                    .getKey();
            tareaHabilidad.setId_tarea_habilidad(id);
            return tareaHabilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public void delete(Integer id){
        String query = "DELETE FROM TareaHabilidad WHERE id_tarea_habilidad = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
