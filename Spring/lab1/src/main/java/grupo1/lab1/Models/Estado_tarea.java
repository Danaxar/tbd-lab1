package grupo1.lab1.Models;

/**
 * Clase que representa una emergencia
 */
public class Estado_tarea{
    private Integer id_Estado_tarea;
    private String nombre_Estado_tarea;


    /**
     * Obtiene el id (integer) del estado de una tarea
     * @return Integer
     */
    public Integer getId_Estado_tarea() {
        return id_Estado_tarea;
    }


    /**
     * Modifica un id (integer) a una Emergencia
     * @param id_emergency
     */
    public void setId_Estado_tarea(Integer id_emergencia) {
        this.id_Estado_tarea = id_Estado_tarea;
    }


    /**
     * Obtiene el nombre (string) del estado de una tarea
     * @return String
     */
    public String getNombre_Estado_tarea() {
        return nombre_Estado_tarea;
    }


    /**
     * Modifica el nombre (string) del estado de una tarea
     */
    public void setNombre_Estado_tarea(String nombre_Estado_tarea) {
        this.nombre_Estado_tarea = nombre_Estado_tarea;
    }

}