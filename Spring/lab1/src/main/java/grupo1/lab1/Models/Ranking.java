package grupo1.lab1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ranking {

    @JsonProperty("id_ranking")
    private Integer id_ranking;
    @JsonProperty("puntaje_ranking")
    private Integer puntaje_ranking;
    @JsonProperty("id_voluntario")
    private Integer id_voluntario;
    @JsonProperty("id_tarea")
    private Integer id_tarea;

    // Getters

    public Integer getId() {
        return id_ranking;
    }

    public Integer getPuntaje() {
        return puntaje_ranking;
    }

    public Integer getIdVoluntario() {
        return id_voluntario;
    }

    public Integer getIdTarea() {
        return id_tarea;
    }

    // Setters

    public void setId(Integer id_ranking) {
        this.id_ranking = id_ranking;
    }

    public void setPuntaje(Integer puntaje_ranking) {
        this.puntaje_ranking = puntaje_ranking;
    }

    public void setIdVoluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public void setIdTarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }
}
