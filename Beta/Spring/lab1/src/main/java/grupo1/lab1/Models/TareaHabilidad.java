package grupo1.lab1.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase que representa una tabla intermedia entre tarea y habilidad
 */

public class  TareaHabilidad {

    @JsonProperty("id_tarea_habilidad")
    private Integer id_tarea_habilidad;
    @JsonProperty("id_eme_habilidad")
    private Integer id_eme_Habilidad;
    @JsonProperty("id_tarea")
    private Integer id_tarea;

    public Integer getId_eme_Habilidad() {
        return id_eme_Habilidad;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    /**
     * Obtiene el id (integer) de una tarea_habilidad
     * @return Integer
     */
    public Integer getId_tarea_habilidad() {
        return id_tarea_habilidad;
    }

    /**
     * Modifica un id (integer) a una tarea_habilidad
     * @param id_tarea_habilidad
     */
    public void setId_tarea_habilidad(Integer id_tarea_habilidad) {
        this.id_tarea_habilidad = id_tarea_habilidad;
    }

    public void setId_emeHabilidad(Integer id_eme_Habilidad) {
        this.id_eme_Habilidad = id_eme_Habilidad;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }



}