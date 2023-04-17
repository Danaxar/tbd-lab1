package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EstadoTarea;
import grupo1.lab1.Models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Institucion> findAll() {
        List<Institucion> institucions;
        String query = "SELECT * FROM Institucion";
        try(Connection conn = sql2o.open()){
            institucions = conn.createQuery(query).executeAndFetch(Institucion.class);
            return institucions;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Institucion findById(Integer id) {
        Institucion encontrada;
        String query = "SELECT * FROM Institucion WHERE id_institucion = :id";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Institucion.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Institucion> findByNombre(String nombre) {
        List<Institucion> instituciones;
        String query = "SELECT * FROM institucion WHERE nombre_institucion = :nombre";
        try (Connection con = sql2o.open()) {
            instituciones = con.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetch(Institucion.class);
            return instituciones;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Institucion save(Institucion institucion) {
        String query = "INSERT INTO institucion (nombre_institucion) VALUES (:nombre)";
        try (Connection conn = sql2o.open()) {
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("nombre", institucion.getNombre_institucion())
                    .executeUpdate()
                    .getKey();
            institucion.setId_institucion(id);
            return institucion;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Institucion update(Institucion institucion){
        String query = "UPDATE institucion SET nombre_institucion = :nombre WHERE id_institucion = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("nombre", institucion.getNombre_institucion())
                    .addParameter("id", institucion.getId_institucion())
                    .executeUpdate();
            return institucion;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;

    }
    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM institucion WHERE id_institucion = :id";
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
