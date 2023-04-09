package grupo1.lab1.Models;


/**
 * Clase que representa una tabla intermedia entre Emergencia y habilidad
 */

public class EmeHabilidad {
    private Integer id_eme_habilidad;
    private Integer id_emergencia;
    private Integer id_habilidad;

    // Getters
    /**
     * Obtiene el id (integer) de una Eme_habilidad
     * @return Integer
     */
    public Integer getId() {
        return id_eme_habilidad;
    }

    /**
     * Obtiene el id de la emergencia (integer) de una Eme_habilidad
     * @return Integer
     */
    public Integer getId_emergencia() {
        return id_emergencia;
    }

    /**
     * Obtiene el id de la habilidad (integer) de una Eme_habilidad
     * @return Integer
     */
    public Integer getId_habilidad() {
        return id_habilidad;
    }

    // Setters
    /**
     * Modifica un id (integer) a una Eme_habilidad
     * @param id_eme_habilidad id de la tabla intermedia
     */
    public void setId(Integer id_eme_habilidad) {
        this.id_eme_habilidad = id_eme_habilidad;
    }

    /**
     * Modifica el id de la emergencia (integer) de una Eme_habilidad
     * @param id_emergencia id de la emergencia
     */
    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    /**
     * Modifica el id de la habilidad (integer) de una Eme_habilidad
     * @param id_habilidad id de la habilidad
     */
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}