package grupo1.lab1.Repositories;

import grupo1.lab1.Models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Voluntario findById(Integer id) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE id_voluntario = :id";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByNombre(String nombre) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE nombre = :nombre";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByApellido(String apellido) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE apellido = :apellido";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("apellido", apellido)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByTelefono(String telefono) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE telefono = :telefono";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("telefono", telefono)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByContrasena(String contrasena) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE contrasena = :contrasena";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("contrasena", contrasena)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByFechaNacimiento(Date fecha_nacimiento) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE fecha_nacimiento = :fecha_nacimiento";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("fecha_nacimiento", fecha_nacimiento)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByDisponibilidad(String disponibilidad) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE disponibilidad = :disponibilidad";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("disponibilidad", disponibilidad)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Voluntario> findAll() {
        List<Voluntario> voluntarios;
        String query = "SELECT * FROM Voluntario";
        try(Connection conn = sql2o.open()){
            voluntarios = conn.createQuery(query)
                    .executeAndFetch(Voluntario.class);
            return voluntarios;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario save(Voluntario voluntario) {
        String query = "INSERT INTO Voluntario (nombres_voluntario, apellidos_voluntario, telefono_voluntario, contrasena_voluntario, fecha_nac_voluntario, disponibilidad_voluntario, rut_voluntario) VALUES (:nombre, :apellido, :telefono, :contrasena, :fecha_nacimiento, :disponibilidad, :rut)";
        try(Connection conn = sql2o.open()){
            voluntario.setId((int) conn.createQuery(query, true)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("fecha_nacimiento", voluntario.getFechaNacimiento())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("rut", voluntario.getRut())
                    .executeUpdate()
                    .getKey());
            return voluntario;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM Voluntario WHERE id_voluntario = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
