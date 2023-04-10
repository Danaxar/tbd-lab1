package grupo1.lab1.Models;

/**
 * Clase que representa la habilidad de un voluntario
 */
public class VoluntarioHabilidad {
    private Integer id_voluntario_habilidad;

    /**
     * Constructor vacio
     * @param id_voluntario_habilidad
     */
    public VoluntarioHabilidad(Integer id_voluntario_habilidad) {
        this.id_voluntario_habilidad = id_voluntario_habilidad;
    }

    /**
     * Obtiene el id de la habilidad del voluntario
     * @return
     */
    public Integer getId_voluntario_habilidad() {
        return id_voluntario_habilidad;
    }

    /**
     * Modifica el id de la habilidad del voluntario
     * @param id_voluntario_habilidad
     */
    public void setId_voluntario_habilidad(Integer id_voluntario_habilidad) {
        this.id_voluntario_habilidad = id_voluntario_habilidad;
    }
}
