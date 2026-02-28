package com.tallerbicicletas.model;

public abstract class Persona {

    private int id;
    private String nombre;
    private Taller taller;

    public Persona(int id, String nombre,Taller taller) {
        this.id = id;
        this.nombre = nombre;
        this.taller=taller;
    }
    public int getId() {
        return id;
    }
}