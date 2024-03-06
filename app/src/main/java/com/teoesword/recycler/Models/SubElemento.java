package com.teoesword.recycler.Models;

public class SubElemento {
    private String valor, unit;

    // Constructor
    public SubElemento(String valor, String unit) {
        this.valor = valor; this.unit= unit;
    }

    // Getters y setters

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
