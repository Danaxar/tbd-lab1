package com.example.resq.Repository;

import com.example.resq.Models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Voluntario> findAllVoluntario() {
        List<Voluntario> salida;
        String query = "SELECT * FROM Voluntario";
        try (Connection connection = sql2o.open()) {
            salida = connection.createQuery(query).executeAndFetch(Voluntario.class);
            return salida;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Voluntario findVoluntarioById(Integer id) {
        Voluntario salida;
        String query = "SELECT * FROM Voluntario WHERE id = :id";
        try (Connection connection = sql2o.open()) {
            salida = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
            return salida;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Voluntario findVoluntarioByRut(String rut) {
        Voluntario salida;
        String query = "SELECT * FROM Voluntario WHERE rut = :rut";
        try (Connection connection = sql2o.open()) {
            salida = connection.createQuery(query)
                    .addParameter("rut", rut)
                    .executeAndFetchFirst(Voluntario.class);
            return salida;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Voluntario> traerVoluntariosCercanos(Integer id_emergencia, Integer limite) {
        List<Voluntario> salida;
        String query = "SELECT vol.id, vol.rut, vol.nombres, vol.apellidos, vol.fecha_nac, vol.disponibilidad, vol.telefono, vol.rol, vol.contrasena, vol.region, vol.longitud, vol.latitud, vol.geom " +
                "FROM( SELECT (ST_Distance (eme.geom, vol.geom)) AS distancias, vol.id, vol.rut, vol.nombres, vol.apellidos, vol.fecha_nac, vol.disponibilidad, vol.telefono, vol.rol, vol.contrasena, vol.region, vol.longitud, vol.latitud, vol.geom " +
                "FROM emergencia AS eme " +
                "INNER JOIN voluntario_emergencia as volEme ON volEme.id_emergencia = eme.id_emergencia " +
                "INNER JOIN voluntario as vol ON volEme.id_voluntario = vol.id " +
                "WHERE eme.id_emergencia = :id_emergencia " +
                "ORDER BY distancias ASC " +
                "LIMIT :limite" +
                ") AS vol;";
        try (Connection connection = sql2o.open()) {
            salida = connection.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .addParameter("limite", limite)
                    .executeAndFetch(Voluntario.class);
            return salida;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Voluntario> getVoluntariosByEmergencia(Integer id_emergencia) {
        List<Voluntario> salida;
        String query = "SELECT vol.id, vol.rut, vol.nombres, vol.apellidos, vol.fecha_nac, vol.disponibilidad, vol.telefono, vol.rol, vol.contrasena, vol.region, vol.longitud, vol.latitud, vol.geom " +
                "FROM emergencia eme " +
                "INNER JOIN voluntario_emergencia as volEme ON eme.id_emergencia = volEme.id_emergencia " +
                "INNER JOIN voluntario as vol ON vol.id = volEme.id_voluntario " +
                "WHERE eme.id_emergencia = :id_emergencia";
        try (Connection connection = sql2o.open()) {
            salida = connection.createQuery(query)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(Voluntario.class);
            return salida;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void saveVoluntario(Voluntario voluntario){
        String query = "INSERT INTO Voluntario (rut, nombres, apellidos, fecha_nac, disponibilidad, telefono, rol, contrasena, region, longitud, latitud, geom) " +
                "VALUES (:rut, :nombres, :apellidos, :fecha_nac, :disponibilidad, :telefono, :rol, :contrasena, :region, :longitud, :latitud, ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')'))";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("nombres", voluntario.getNombres())
                    .addParameter("apellidos", voluntario.getApellidos())
                    .addParameter("fecha_nac", voluntario.getFecha_nac())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("rol", voluntario.getRol())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("region", voluntario.getRegion())
                    .addParameter("longitud", voluntario.getLongitud())
                    .addParameter("latitud", voluntario.getLatitud())
                    .executeUpdate();

        }
    }

    @Override
    public Voluntario updateVoluntario(Voluntario voluntario){
        String query = "UPDATE Voluntario SET rut = :rut, nombres = :nombres, apellidos = :apellidos, fecha_nac = :fecha_nac," +
                " disponibilidad = :disponibilidad, telefono = :telefono, rol = :rol, contrasena = :contrasena, region = :region," +
                " longitud = :longitud, latitud = :latitud, geom = ST_PointFromText('POINT(' || :longitud || ' ' || :latitud || ')')" +
                " WHERE id = :id_voluntario";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("id_voluntario", voluntario.getId())
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("nombres", voluntario.getNombres())
                    .addParameter("apellidos", voluntario.getApellidos())
                    .addParameter("fecha_nac", voluntario.getFecha_nac())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("rol", voluntario.getRol())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("region", voluntario.getRegion())
                    .addParameter("longitud", voluntario.getLongitud())
                    .addParameter("latitud", voluntario.getLatitud())
                    .executeUpdate();
            return voluntario;
        }
    }

    @Override
    public boolean deleteVoluntario(Integer id) {
        String query = "DELETE FROM Voluntario WHERE id = :id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
