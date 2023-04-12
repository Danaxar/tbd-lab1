package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EstadoTarea;
import grupo1.lab1.Models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Habilidad> findAll() {
        List<Habilidad> habilidades;
        String query = "SELECT * FROM Habilidad";
        try (Connection conn = sql2o.open()) {
            habilidades = conn.createQuery(query).executeAndFetch(Habilidad.class);
            return habilidades;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public Habilidad findById(Integer id) {
        Habilidad habilidad;
        String query = "SELECT * FROM Habilidad WHERE id_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            habilidad = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
            return habilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public Habilidad findByNombre(String nombre) {
        Habilidad habilidad;
        String query = "SELECT * FROM Habilidad WHERE nombre_habilidad = :nombre";
        try (Connection conn = sql2o.open()) {
            habilidad = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Habilidad.class);
            return habilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public Habilidad save(Habilidad habilidad) {
        String query = "INSERT INTO Habilidad (nombre_habilidad, puntaje_habilidad) VALUES (:nombre, :puntaje)";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .addParameter("nombre", habilidad.getNombre_habilidad())
                    .addParameter("puntaje", habilidad.getPuntaje_habilidad())
                    .executeUpdate()
                    .getKey();
            habilidad.setId_habilidad(id);
            return habilidad;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Habilidad update(Habilidad habilidad){
        String query = "UPDATE Habilidad SET nombre_habilidad = :nombre, puntaje_habilidad = :puntaje WHERE id_habilidad = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("nombre", habilidad.getNombre_habilidad())
                    .addParameter("puntaje", habilidad.getPuntaje_habilidad())
                    .addParameter("id", habilidad.getId_habilidad())
                    .executeUpdate();
            return habilidad;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;

    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM Habilidad WHERE id_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
