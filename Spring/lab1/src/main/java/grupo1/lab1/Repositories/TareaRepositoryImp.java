package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EstadoTarea;
import grupo1.lab1.Models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea> findAll() {
        List<Tarea> salida;
        String query = "SELECT * FROM Tarea";
        try(Connection conn = sql2o.open()){
            salida = conn.createQuery(query).executeAndFetch(Tarea.class);
            return salida;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea findById(Integer id) {
        Tarea encontrada;
        String query = "SELECT * FROM Tarea WHERE id_tarea = :id";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Tarea> findByNombre(String nombre) {
        List<Tarea> encontrada;
        String query = "SELECT * FROM Tarea WHERE nombre_tarea = :nombre";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetch(Tarea.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Tarea> findByEmergencia(Integer id_emergencia) {
        List<Tarea> encontrada;
        String query = "SELECT * FROM Tarea WHERE id_emergencia = :id_emergencia";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(Tarea.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea save(Tarea tarea) {
        String query = "INSERT INTO Tarea (nombre_tarea, id_emergencia) VALUES (:nombre, :id_emergencia)";
        try (Connection conn = sql2o.open()) {
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("nombre", tarea.getNombre_tarea())
                    .addParameter("id_emergencia", tarea.getIdEmergencia())
                    .executeUpdate()
                    .getKey();
            tarea.setId(id);
            return tarea;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea update(Tarea tarea){
        String query = "UPDATE Tarea SET nombre_tarea = :nombre, id_emergencia = :id_emergencia WHERE id_tarea = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("nombre", tarea.getNombre_tarea())
                    .addParameter("id_emergencia", tarea.getIdEmergencia())
                    .addParameter("id", tarea.getId())
                    .executeUpdate();
            return tarea;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;

    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Tarea WHERE id_tarea = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
