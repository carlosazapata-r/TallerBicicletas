package com.tallerbicicletas.model;

public class Bicicleta {

    private String color;
    private String marca;
    private String nombreSerie;
    private TipoBicicleta tipo;

    public Bicicleta(String color, String marca, String nombreSerie, TipoBicicleta tipo) {
        this.color = color;
        this.marca = marca;
        this.nombreSerie = nombreSerie;
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    public TipoBicicleta getTipo() {
        return tipo;
    }
}
