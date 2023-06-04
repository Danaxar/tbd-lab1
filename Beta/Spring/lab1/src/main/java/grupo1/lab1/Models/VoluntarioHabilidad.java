package grupo1.lab1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase que representa la habilidad de un voluntario
 */
public class VoluntarioHabilidad {
    @JsonProperty("id_vol_habilidad")
    private Integer id_vol_habilidad;
    @JsonProperty("id_voluntario")
    private Integer id_voluntario;
    @JsonProperty("id_habilidad")
    private Integer id_habilidad;

    public Integer getId_vol_habilidad() {
        return id_vol_habilidad;
    }

    public void setId_vol_habilidad(Integer id_vol_habilidad) {
        this.id_vol_habilidad = id_vol_habilidad;
    }

    public Integer getId_Voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getId_Habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}

