package grupo1.lab1.Repositories;

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
            salida = conn.createQuery(query).setAutoDeriveColumnNames(true).executeAndFetch(Tarea.class);
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
    public Tarea findByNombre(String nombre) {
        Tarea encontrada;
        String query = "SELECT * FROM Tarea WHERE nombre = :nombre";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Tarea.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea findByEmergencia(Integer id_emergencia) {
        Tarea encontrada;
        String query = "SELECT * FROM Tarea WHERE id_emergencia = :id_emergencia";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetchFirst(Tarea.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Tarea save(Tarea tarea) {
        Tarea agregada;
        String query = "INSERT INTO Tarea (nombre) VALUES (:nombre)";
        try (Connection con = sql2o.open()) {
            agregada = con.createQuery(query, true)
                    .addParameter("nombre", tarea.getNombre())
                    .executeAndFetchFirst(Tarea.class);
            tarea.setId(agregada.getId());
            return agregada;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Tarea WHERE id_tarea = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
