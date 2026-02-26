package com.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Taller {

    private int id;
    private String nombre;
    private String telefono;

    private List<Bicicleta> bicicletas;
    private List<Persona> personas;
    private List<Servicio> servicios;

    public Taller(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.bicicletas = new ArrayList<>();
        this.personas = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }
}
