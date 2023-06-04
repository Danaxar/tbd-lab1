package grupo1.lab1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {
    @JsonProperty("id_tarea")
    private Integer id_tarea;
    @JsonProperty("nombre_tarea")
    private String nombre_tarea;
    @JsonProperty("id_emergencia")
    private Integer id_emergencia;

    // Getters
    public Integer getId() {
        return id_tarea;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public Integer getIdEmergencia() {
        return id_emergencia;
    }

    // Setters
    public void setId(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public void setIdEmergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
}
