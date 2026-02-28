package com.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private String direccion;
    private String telefono;
    private List<Bicicleta> listaBicicletas;

    public Cliente(int id, String nombre,Taller taller, String direccion, String telefono) {
        super(id, nombre,taller);
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaBicicletas = new ArrayList<>();
    }
    public void agregarBicicleta(Bicicleta bicicleta){
        if(bicicleta != null){
            listaBicicletas.add(bicicleta);
        }
    }
}