package grupo1.lab1.Models;

/**
 * Clase que representa una habilidad
 */
public class Habilidad {
    private Integer id_habilidad;
    private String name_habilidad;
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
     * @param id_ability
     */
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    /**
     * Obtiene el nombre de una Habilidad
     * @return String
     */
    public String getName_habilidad() {
        return name_habilidad;
    }

    /**
     * setea el nombre de una habilidad
     * @param name_ability
     */
    public void setName_habilidad(String name_habilidad) {
        this.name_habilidad = name_habilidad;
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
     * @param description_ability
     */

     public void setPuntaje_habilidad(Integer puntaje_habilidad){
    this.puntaje_habilidad = puntaje_habilidad;
    }
}