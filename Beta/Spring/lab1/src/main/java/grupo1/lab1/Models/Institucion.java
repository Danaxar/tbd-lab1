package grupo1.lab1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Institucion {
    @JsonProperty("id_institucion")
    private Integer id_institucion;
    @JsonProperty("nombre_institucion")
    private String nombre_institucion;

    // Getters

    public String getNombre_institucion() {
        return nombre_institucion;
    }

    public Integer getId_institucion() {
        return id_institucion;
    }

    // Setters

    public void setId_institucion(Integer id_institucion) {
        this.id_institucion = id_institucion;
    }
    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }
}
