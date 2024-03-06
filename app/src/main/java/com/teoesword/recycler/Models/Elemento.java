package com.teoesword.recycler.Models;

import java.util.List;

public class Elemento {
    private String equipo;
    private List<SubElemento> subelementos; // Asumiendo que tienes una clase Subelemento

    // Constructor
    public Elemento(String equipo, List<SubElemento> subelementos) {
        this.equipo = equipo;
        this.subelementos = subelementos;
    }

    // Getters y setters

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public List<SubElemento> getSubelementos() {
        return subelementos;
    }

    public void setSubelementos(List<SubElemento> subelementos) {
        this.subelementos = subelementos;
    }
}
