package com.teoesword.recycler.Models;

import java.util.List;

public class Elemento {
    private String nombre;
    private List<SubElemento> subelementos; // Asumiendo que tienes una clase Subelemento

    // Constructor
    public Elemento(String nombre, List<SubElemento> subelementos) {
        this.nombre = nombre;
        this.subelementos = subelementos;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SubElemento> getSubelementos() {
        return subelementos;
    }

    public void setSubelementos(List<SubElemento> subelementos) {
        this.subelementos = subelementos;
    }
}
