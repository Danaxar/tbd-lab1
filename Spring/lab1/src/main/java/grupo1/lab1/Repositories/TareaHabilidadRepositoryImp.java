package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EstadoTarea;
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
        String query = "SELECT * FROM Tarea_Habilidad";
        try (Connection conn = sql2o.open()) {
            salida = conn.createQuery(query).executeAndFetch(TareaHabilidad.class);
            return salida;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public TareaHabilidad findById(Integer id) {
        TareaHabilidad encontrada;
        String query = "SELECT * FROM Tarea_Habilidad WHERE id_tarea_habilidad = :id";
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
    public List<TareaHabilidad> findById_eme_Habilidad(Integer id){
        List<TareaHabilidad> tareaHabilidades;
        String query = "SELECT * FROM Tarea_Habilidad WHERE id_eme_habilidad = :id_eme_habilidad";
        try(Connection conn = sql2o.open()){
            tareaHabilidades = conn.createQuery(query)
                    .addParameter("id_eme_habilidad", id)
                    .executeAndFetch(TareaHabilidad.class);
            return tareaHabilidades;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<TareaHabilidad> findById_tarea(Integer id_tarea){
        List<TareaHabilidad> tareaHabilidades;
        String query = "SELECT * FROM Tarea_Habilidad WHERE id_tarea = :id_tarea";
        try(Connection conn = sql2o.open()){
            tareaHabilidades = conn.createQuery(query)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(TareaHabilidad.class);
            return tareaHabilidades;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public TareaHabilidad save(TareaHabilidad tareaHabilidad){
        String query = "INSERT INTO Tarea_Habilidad (id_eme_Habilidad, id_tarea) VALUES (:id_eme_Habilidad, :id_tarea)";
        try(Connection conn = sql2o.open()){
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("id_eme_Habilidad", tareaHabilidad.getId_eme_Habilidad())
                    .addParameter("id_tarea", tareaHabilidad.getId_tarea())
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
    public TareaHabilidad update(TareaHabilidad tareaHabilidad){
        String query = "UPDATE Tarea_habilidad SET id_eme_Habilidad = :id_eme_Habilidad, id_tarea = :id_tarea WHERE id_tarea_habilidad = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("id_eme_Habilidad", tareaHabilidad.getId_eme_Habilidad())
                    .addParameter("id_tarea", tareaHabilidad.getId_tarea())
                    .addParameter("id", tareaHabilidad.getId_tarea_habilidad())
                    .executeUpdate();
            return tareaHabilidad;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id){
        String query = "DELETE FROM Tarea_Habilidad WHERE id_tarea_habilidad = :id";
        try(Connection conn = sql2o.open()){
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
