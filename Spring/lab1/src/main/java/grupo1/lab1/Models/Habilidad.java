package grupo1.lab1.Models;

/**
 * Clase que representa una habilidad
 */
public class Habilidad {
    private Integer id_habilidad;
    private String nombre_habilidad;
    private Integer puntaje_habilidad;

    /**
     * Obtiene el id de una Habilidad
     * @return Integer
     */
    public Integer getId_habilidad() {
        return id_habilidad;
    }

    /**
     * setea el id de una habilidad
     * @param id_habilidad
     */
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    /**
     * Obtiene el nombre de una Habilidad
     * @return String
     */
    public String getNombre_habilidad() {
        return nombre_habilidad;
    }

    /**
     * setea el nombre de una habilidad
     * @param nombre_habilidad
     */
    public void setName_habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }

    /**
     * Obtiene el puntaje de una habilidad
     * @return String
     */
    public Integer getPuntaje_habilidad() {
        return puntaje_habilidad;
    }

    /**
     * setea el puntaje de una habilidad
     * @param puntaje_habilidad
     */

    public void setPuntaje_habilidad(Integer puntaje_habilidad){
    this.puntaje_habilidad = puntaje_habilidad;
    }
}