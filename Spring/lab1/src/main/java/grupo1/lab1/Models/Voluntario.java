package grupo1.lab1.Models;

import java.util.Date;

public class Voluntario {
    private Integer id_voluntario;
    private String nombre_voluntario;
    private String apellido_voluntario;
    private Date fecha_nacimiento_voluntario;
    private String disponibilidad_voluntario;
    private String telefono_voluntario;
    private String contrasena_voluntario;

    // Getters
    public Integer getId() {
        return id_voluntario;
    }

    public String getNombre() {
        return nombre_voluntario;
    }

    public String getApellido() {
        return apellido_voluntario;
    }

    public Date getFechaNacimiento() {
        return fecha_nacimiento_voluntario;
    }

    public String getDisponibilidad() {
        return disponibilidad_voluntario;
    }

    public String getTelefono() {
        return telefono_voluntario;
    }

    public String getContrasena() {
        return contrasena_voluntario;
    }

    // Setters

    public void setId(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public void setNombre(String nombre_voluntario) {
        this.nombre_voluntario = nombre_voluntario;
    }

    public void setApellido(String apellido_voluntario) {
        this.apellido_voluntario = apellido_voluntario;
    }

    public void setFechaNacimiento(Date fecha_nacimiento_voluntario) {
        this.fecha_nacimiento_voluntario = fecha_nacimiento_voluntario;
    }

    public void setDisponibilidad(String disponibilidad_voluntario) {
        this.disponibilidad_voluntario = disponibilidad_voluntario;
    }

    public void setTelefono(String telefono_voluntario) {
        this.telefono_voluntario = telefono_voluntario;
    }

    public void setContrasena(String contrasena_voluntario) {
        this.contrasena_voluntario = contrasena_voluntario;
    }
}
