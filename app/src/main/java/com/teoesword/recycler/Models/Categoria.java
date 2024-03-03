package com.teoesword.recycler.Models;

import java.util.List;

public class Categoria {
    private String nombre;
    private String informacionAdicional;
    private int edadCategoria;
    private String horarioCategoria;
    private List<Elemento> elementos;
    private boolean isExpanded; // Nueva propiedad para rastrear si está expandida

    // Constructor
    public Categoria(String nombre, String informacionAdicional, int edadCategoria, String horarioCategoria, List<Elemento> elementos) {
        this.nombre = nombre;
        this.informacionAdicional = informacionAdicional;
        this.edadCategoria = edadCategoria;
        this.horarioCategoria = horarioCategoria;
        this.elementos = elementos;
        this.isExpanded = false; // Por defecto, no está expandida
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public int getEdadCategoria() {
        return edadCategoria;
    }

    public void setEdadCategoria(int edadCategoria) {
        this.edadCategoria = edadCategoria;
    }

    public String getHorarioCategoria() {
        return horarioCategoria;
    }

    public void setHorarioCategoria(String horarioCategoria) {
        this.horarioCategoria = horarioCategoria;
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
