package grupo1.lab1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase que representa una emergencia
 */
public class EstadoTarea{
    @JsonProperty("id_estado_tarea")
    private Integer id_estado_tarea;
    @JsonProperty("nombre_estado_tarea")
    private String nombre_estado_tarea;


    /**
     * Obtiene el id (integer) del estado de una tarea
     * @return Integer
     */
    public Integer getId_Estado_tarea() {
        return id_estado_tarea;
    }


    /**
     * Modifica un id (integer) a una Emergencia
     * @param id_estado_tarea id de la emergencia
     */
    public void setId_Estado_tarea(Integer id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }


    /**
     * Obtiene el nombre (string) del estado de una tarea
     * @return String
     */
    public String getNombre_Estado_tarea() {
        return nombre_estado_tarea;
    }


    /**
     * Modifica el nombre (string) del estado de una tarea
     */
    public void setNombre_Estado_tarea(String nombre_Estado_tarea) {
        this.nombre_estado_tarea = nombre_Estado_tarea;
    }

}