package grupo1.lab1.Repositories;

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
    public List<Institucion> findAll() {
        List<Institucion> salida;
        String query = "SELECT * FROM Institucion";
        try(Connection conn = sql2o.open()){
            salida = conn.createQuery(query).setAutoDeriveColumnNames(true).executeAndFetch(Institucion.class);
            return salida;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public Institucion save(Institucion institucion) {
        Institucion agregada;
        String query = "INSERT INTO institucion (nombre) VALUES (:nombre)";
        try (Connection con = sql2o.open()) {
            agregada = con.createQuery(query, true)
                    .addParameter("nombre", institucion.getNombre())
                    .executeAndFetchFirst(Institucion.class);
            institucion.setId(agregada.getId());
            return agregada;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM instituciones WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Institucion findByNombre(String nombre) {
        String sql = "SELECT * FROM instituciones WHERE nombre = :nombre";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Institucion.class);
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
