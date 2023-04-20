package grupo1.lab1.Repositories;

import grupo1.lab1.Models.EstadoTarea;
import grupo1.lab1.Models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.text.SimpleDateFormat;
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
    public List<Voluntario> findByNombre(String nombre) {
        List<Voluntario> encontrada;
        String query = "SELECT * FROM Voluntario WHERE nombres_voluntario = :nombre";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("nombre", nombre)
                    .executeAndFetch(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Voluntario> findByApellido(String apellido) {
        List<Voluntario> encontrada;
        String query = "SELECT * FROM Voluntario WHERE apellidos_voluntario = :apellido";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("apellido", apellido)
                    .executeAndFetch(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByTelefono(String telefono) {
        Voluntario encontrada;
        String query = "SELECT * FROM Voluntario WHERE telefono_voluntario = :telefono";
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
    public List<Voluntario> findByFechaNacimiento(String fecha_nacimiento) {
        List<Voluntario> encontrada;
        String query = "SELECT * FROM Voluntario WHERE fecha_nac_voluntario = :fecha_nacimiento";
        try(Connection conn = sql2o.open()){
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDate = formato.parse(fecha_nacimiento);
            encontrada = conn.createQuery(query)
                    .addParameter("fecha_nacimiento", fechaDate)
                    .executeAndFetch(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Voluntario> findByDisponibilidad(String disponibilidad) {
        List<Voluntario> encontrada;
        String query = "SELECT * FROM Voluntario WHERE disponibilidad_voluntario = :disponibilidad";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("disponibilidad", disponibilidad)
                    .executeAndFetch(Voluntario.class);
            return encontrada;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Voluntario> findByRol(String rol) {
        List<Voluntario> encontrada;
        String query = "SELECT * FROM Voluntario WHERE rol_voluntario = :rol";
        try(Connection conn = sql2o.open()){
            encontrada = conn.createQuery(query)
                    .addParameter("rol", rol)
                    .executeAndFetch(Voluntario.class);
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
        String query = "INSERT INTO Voluntario (nombres_voluntario, apellidos_voluntario, telefono_voluntario, contrasena_voluntario, fecha_nac_voluntario, disponibilidad_voluntario, rut_voluntario, rol_voluntario) VALUES (:nombre, :apellido, :telefono, :contrasena, :fecha_nacimiento, :disponibilidad, :rut, :rol)";
        try(Connection conn = sql2o.open()){
            voluntario.setId((int) conn.createQuery(query, true)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("fecha_nacimiento", voluntario.getFechaNacimiento())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("rol", voluntario.getRol_voluntario())
                    .executeUpdate()
                    .getKey());
            return voluntario;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario update(Voluntario voluntario){
        String query = "UPDATE Voluntario " +
                "SET nombres_voluntario = :nombre, " +
                "apellidos_voluntario = :apellido, " +
                "telefono_voluntario = :telefono, " +
                "contrasena_voluntario = :contrasena, " +
                "fecha_nac_voluntario = :fecha_nacimiento, " +
                "disponibilidad_voluntario = :disponibilidad, " +
                "rut_voluntario = :rut, " +
                "rol_voluntario = :rol " +
                "WHERE id_voluntario = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("fecha_nacimiento", voluntario.getFechaNacimiento())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("rol", voluntario.getRol_voluntario())
                    .addParameter("id", voluntario.getId())
                    .executeUpdate();
            return voluntario;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM Voluntario WHERE id_voluntario = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Voluntario findByRutAndContrasena(String rut, String contrasena){
        Voluntario encontrado;
        String query = "SELECT * FROM voluntario WHERE rut_voluntario = :rut AND contrasena_voluntario = :contrasena";
        try(Connection conn = sql2o.open()){
            encontrado = conn.createQuery(query)
                    .addParameter("rut", rut)
                    .addParameter("contrasena", contrasena)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrado;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Voluntario findByRut(String rut){
        Voluntario encontrado;
        String query = "SELECT * FROM voluntario WHERE rut_voluntario = :rut";
        try(Connection conn = sql2o.open()){
            encontrado = conn.createQuery(query)
                    .addParameter("rut", rut)
                    .executeAndFetchFirst(Voluntario.class);
            return encontrado;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


}
