package com.tallerbicicletas.model;

public abstract class Persona {

    private String id;
    private String nombre;
    private Taller taller;

    public Persona(String id, String nombre,Taller taller) {
        this.id = id;
        this.nombre = nombre;
        this.taller=taller;
    }
    public String getId() {
        return id;
    }
}