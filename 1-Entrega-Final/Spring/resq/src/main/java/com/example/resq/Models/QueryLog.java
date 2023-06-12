package com.example.resq.Models;


import java.time.LocalDateTime;




public class QueryLog {
    private Integer id;

    private String usuario;
    private String query;

    private String tipoOperacion;
    private String tabla;
    private LocalDateTime tiempo;


    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getQuery() {
        return query;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public String getTabla() {
        return tabla;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }
}
