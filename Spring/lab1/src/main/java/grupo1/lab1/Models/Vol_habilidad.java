package grupo1.lab1.Models;


/**
 * Clase que representa una tabla intermedia entre Voluntario y habilidad
 */

public class VolAbility {
    private Integer id_vol_habilidad;

    /**
     * Obtiene el id (integer) de una Vol_habilidad
     * @return Integer
     */
    public Integer getId_vol_habilidad() {
        return id_vol_habilidad;
    }

    /**
     * Modifica un id (integer) a una Vol_habilidad
     * @param id_vol_habilidad
     */
    public void setId_vol_habilidad(Integer id_vol_habilidad) {
        this.id_vol_habilidad = id_vol_habilidad;
    }

}