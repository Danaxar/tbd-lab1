package grupo1.lab1.Models;

public class Tarea {
    private Integer id_tarea;
    private String nombre_tarea;
    private Integer id_emergencia;

    // Getters
    public Integer getId() {
        return id_tarea;
    }

    public String getNombre() {
        return nombre_tarea;
    }

    public Integer getIdEmergencia() {
        return id_emergencia;
    }

    // Setters
    public void setId(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public void setNombre(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public void setIdEmergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
}
