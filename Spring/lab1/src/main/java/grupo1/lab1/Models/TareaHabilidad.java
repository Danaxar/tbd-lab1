package grupo1.lab1.Models;


/**
 * Clase que representa una tabla intermedia entre tarea y habilidad
 */

public class TareaHabilidad {
    private Integer id_tarea_habilidad;

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

}