package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EstadoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EstadoTareaRepositoryImp implements EstadoTareaRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<EstadoTarea> findAll(){
        List<EstadoTarea> estadosTareas;
        String query = "SELECT * FROM EstadoTarea";
        try (Connection conn = sql2o.open()) {
            estadosTareas = conn.createQuery(query).setAutoDeriveColumnNames(true).executeAndFetch(EstadoTarea.class);
            return estadosTareas;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public EstadoTarea findById(Integer id){
        EstadoTarea estadoTarea;
        String query = "SELECT * FROM EstadoTarea WHERE id_estado_tarea = :id";
        try(Connection conn = sql2o.open()){
            estadoTarea = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EstadoTarea.class);
            return estadoTarea;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public EstadoTarea findByNombre(String nombre){
        EstadoTarea estadoTarea;
        String query = "SELECT * FROM EstadoTarea WHERE nombre_estado_tarea = :nombre";
        try(Connection conn = sql2o.open()){
            estadoTarea = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(EstadoTarea.class);
            return estadoTarea;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public EstadoTarea save(EstadoTarea estadoTarea){
        String query = "INSERT INTO EstadoTarea (nombre) VALUES (:nombre)";
        try(Connection conn = sql2o.open()){
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("nombre", estadoTarea.getNombre_Estado_tarea())
                    .executeUpdate()
                    .getKey();
            estadoTarea.setId_Estado_tarea(id);
            return estadoTarea;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public void delete(Integer id){
        String query = "DELETE FROM EstadoTarea WHERE id_estado_tarea = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
