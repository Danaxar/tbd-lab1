package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergencia> findAll() {
        List<Emergencia> salida;
        String query = "SELECT * FROM Emergencia";
        try (Connection conn = sql2o.open()) {
            salida = conn.createQuery(query).executeAndFetch(Emergencia.class);
            return salida;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Emergencia findById(Integer id) {
        Emergencia encontrada;
        String query = "SELECT * FROM Emergencia WHERE id_emergencia = :id";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Emergencia findByNombre(String nombre) {
        Emergencia encontrada;
        String query = "SELECT * FROM Emergencia WHERE nombre = :nombre";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Emergencia.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Emergencia findByGravedad(String gravedad) {
        Emergencia encontrada;
        String query = "SELECT * FROM Emergencia WHERE gravedad = :gravedad";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("gravedad", gravedad)
                    .executeAndFetchFirst(Emergencia.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Emergencia findByFecha(Date fecha) {
        Emergencia encontrada;
        String query = "SELECT * FROM Emergencia WHERE fecha = :fecha";
        try (Connection conn = sql2o.open()) {
            encontrada = conn.createQuery(query)
                    .addParameter("fecha", fecha)
                    .executeAndFetchFirst(Emergencia.class);
            return encontrada;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Emergencia save(Emergencia emergencia) {
        String query = "INSERT INTO Emergencia (nombre_emergencia, gravedad_emergencia, fecha_emergencia) VALUES (:nombre, :gravedad, :fecha)";
        try (Connection conn = sql2o.open()) {
            Integer id = (int) conn.createQuery(query, true)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("gravedad", emergencia.getGravedad())
                    .addParameter("fecha", emergencia.getFecha())
                    .executeUpdate()
                    .getKey();
            emergencia.setId(id);
            return emergencia;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM Emergencia WHERE id_emergencia = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
