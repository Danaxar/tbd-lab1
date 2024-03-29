package grupo1.lab1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Voluntario {
    @JsonProperty("id_voluntario")
    private Integer id_voluntario;
    @JsonProperty("rut_voluntario")
    private String rut_voluntario;
    @JsonProperty("nombres_voluntario")
    private String nombres_voluntario;
    @JsonProperty("apellidos_voluntario")
    private String apellidos_voluntario;
    @JsonProperty("fecha_nac_voluntario")
    private Date fecha_nac_voluntario;
    @JsonProperty("disponibilidad_voluntario")
    private String disponibilidad_voluntario;
    @JsonProperty("telefono_voluntario")
    private String telefono_voluntario;
    @JsonProperty("rol_voluntario")
    private String rol_voluntario;
    @JsonProperty("contrasena_voluntario")
    private String contrasena_voluntario;

    public String getRol_voluntario() {
        return rol_voluntario;
    }

    // Getters
    public Integer getId() {
        return id_voluntario;
    }

    public String getNombre() {
        return this.nombres_voluntario;
    }

    public String getApellido() {
        return this.apellidos_voluntario;
    }

    public Date getFechaNacimiento() {
        return fecha_nac_voluntario;
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

    public String getRut() {return rut_voluntario;}

    // Setters

    public void setId(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public void setNombre(String nombres_voluntario) {
        this.nombres_voluntario = nombres_voluntario;
    }

    public void setApellido(String apellidos_voluntario) {
        this.apellidos_voluntario = apellidos_voluntario;
    }

    public void setFechaNacimiento(Date fecha_nac_voluntario) {
        this.fecha_nac_voluntario = fecha_nac_voluntario;
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
    public void setRut(String rut_voluntario) {this.rut_voluntario = rut_voluntario;}

    public void setRol_voluntario(String rol_voluntario) {
        this.rol_voluntario = rol_voluntario;
    }
}
