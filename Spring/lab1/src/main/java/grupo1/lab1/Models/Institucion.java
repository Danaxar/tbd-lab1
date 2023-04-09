package grupo1.lab1.Models;

public class Institucion {
    private Integer id_institucion;
    private String nombre_institucion;

    // Getters

    public String getNombre() {
        return nombre_institucion;
    }

    public Integer getId() {
        return id_institucion;
    }

    // Setters

    public void setId(Integer id_institucion) {
        this.id_institucion = id_institucion;
    }
}
