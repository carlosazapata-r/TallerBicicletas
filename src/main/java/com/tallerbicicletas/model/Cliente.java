package com.tallerbicicletas.model;

public class Cliente extends Persona {

    private String direccion;
    private String telefono;

    public Cliente(int id, String nombre, String direccion, String telefono) {
        super(id, nombre);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
}