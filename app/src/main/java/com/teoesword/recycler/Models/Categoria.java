package com.teoesword.recycler.Models;

import java.util.List;

public class Categoria {
    private String id_tarea, fecha, descripcion;

    private List<Elemento> elementos;
    private boolean isExpanded; // Nueva propiedad para rastrear si está expandida

    // Constructor
    public Categoria(String id_tarea, String fecha, String descripcion, List<Elemento> elementos) {
        this.id_tarea = id_tarea;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.elementos = elementos;
        this.isExpanded = false; // Por defecto, no está expandida
    }

    // Getters y setters

    public String getid_tarea() {
        return id_tarea;
    }

    public void setid_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
