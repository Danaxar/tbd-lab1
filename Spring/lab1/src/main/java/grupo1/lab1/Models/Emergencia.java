package grupo1.lab1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Clase que representa una emergencia
 */
public class Emergencia{
    @JsonProperty("id_emergencia")
    private Integer id_emergencia;
    @JsonProperty("nombre_emergencia")
    private String nombre_emergencia;
    @JsonProperty("gravedad_emergencia")
    private String gravedad_emergencia;
    @JsonProperty("fecha_emergencia")
    private Date fecha_emergencia;

    //Getters

    /**
     * Obtiene el id (integer) de una Emergencia
     * @return Integer
     */
    public Integer getId() {
        return id_emergencia;
    }

    /**
     * Obtiene el nombre (string) de una Emergencia
     * @return String
     */
    public String getNombre() {
        return nombre_emergencia;
    }

    /**
     * Obtiene la gravedad (string) de una Emergencia
     * @return String
     */
    public String getGravedad() {
        return gravedad_emergencia;
    }

    /**
     * Obtiene la fecha (integer) de una Emergencia
     * @return Date
     */
    public Date getFecha() {
        return fecha_emergencia;
    }

    // Setters

    /**
     * Modifica un id (integer) a una Emergencia
     * @param id_emergencia Id de la emergencia
     */
    public void setId(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    /**
     * Modifica el nombre (string) de una Emergencia
     * @param nombre_emergencia Nombre de la emergencia
     */
    public void setNombre(String nombre_emergencia) {
        this.nombre_emergencia = nombre_emergencia;
    }

    /**
     * Modifica la fecha (date) de una Emergencia
     * @param fecha_emergencia Fecha de la emergencia
     */
    public void setFecha(Date fecha_emergencia) {
        this.fecha_emergencia = fecha_emergencia;
    }

    /**
     * Modifica la gravedad (string) de una Emergencia
     * @param gravedad_emergencia Gravedad de la emergencia
     */
    public void setGravedad(String gravedad_emergencia) {
        this.gravedad_emergencia = gravedad_emergencia;
    }
}