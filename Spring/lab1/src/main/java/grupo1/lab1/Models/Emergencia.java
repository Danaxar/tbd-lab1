package grupo1.lab1.Models;

/**
 * Clase que representa una emergencia
 */
public class Emergencia{
    private Integer id_emergencia;
    private String nombre_emergencia;
    private String gravedad_emergencia;
    private Date fecha_emergencia;


    /**
     * Obtiene el id (integer) de una Emergencia
     * @return Integer
     */
    public Integer getId_emergencia() {
        return id_emergencia;
    }


    /**
     * Modifica un id (integer) a una Emergencia
     * @param id_emergency
     */
    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }


    /**
     * Obtiene el nombre (string) de una Emergencia
     * @return String
     */
    public String getNombre_emergencia() {
        return nombre_emergencia;
    }


    /**
     * Modifica el nombre (string) de una Emergencia
     * @param emergency_details
     */
    public void setNombre_emergencia(String nombre_emergencia) {
        this.nombre_emergencia = nombre_emergencia;
    }


    /**
     * Obtiene la gravedad (string) de una Emergencia
     * @return String
     */
    public String getGravedad_emergencia() {
        return gravedad_emergencia;
    }


    /**
     * Modifica la gravedad (string) de una Emergencia
     * @param status
     */
    public void setGravedad_emergencia(String gravedad_emergencia) {
        this.gravedad_emergencia = gravedad_emergencia;
    }


    /**
     * Obtiene la fecha (integer) de una Emergencia
     * @return Date
     */
    public Date getFecha_emergencia() {
        return fecha_emergencia;
    }


    /**
     * Modifica la fecha (date) de una Emergencia
     */
    public void setFecha_emergencia(Date fecha_emergencia) {
        this.fecha_emergencia = fecha_emergencia;
    }
}