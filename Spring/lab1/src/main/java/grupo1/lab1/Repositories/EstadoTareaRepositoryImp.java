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
        String query = "SELECT * FROM Estado_Tarea";
        try (Connection conn = sql2o.open()) {
            estadosTareas = conn.createQuery(query).executeAndFetch(EstadoTarea.class);
            return estadosTareas;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public EstadoTarea findById(Integer id){
        EstadoTarea estadoTarea;
        String query = "SELECT * FROM Estado_Tarea WHERE id_estado_tarea = :id";
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
    public List<EstadoTarea> findByNombre(String nombre){
        List<EstadoTarea> estadoTarea;
        String query = "SELECT * FROM Estado_Tarea WHERE nombre_estado_tarea = :nombre";
        try(Connection conn = sql2o.open()){
            estadoTarea = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetch(EstadoTarea.class);
            return estadoTarea;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public EstadoTarea save(EstadoTarea estadoTarea){
        String query = "INSERT INTO Estado_Tarea (nombre_estado_tarea) VALUES (:nombre)";
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
    public EstadoTarea update(EstadoTarea estadoTarea){
        String query = "UPDATE Estado_Tarea SET nombre_estado_tarea = :nombre WHERE id_estado_Tarea = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("nombre", estadoTarea.getNombre_Estado_tarea())
                    .addParameter("id", estadoTarea.getId_Estado_tarea())
                    .executeUpdate();
            return estadoTarea;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public boolean delete(Integer id){
        String query = "DELETE FROM Estado_Tarea WHERE id_estado_tarea = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
