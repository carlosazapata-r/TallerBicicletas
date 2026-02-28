package com.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Mecanico extends Persona {
    private List<Servicio> listaServicios;
    private TipoReparacion tipoReparacion;

    public Mecanico(int id, String nombre,Taller taller,TipoReparacion tipoReparacion) {
        super(id, nombre,taller);
        this.listaServicios=new ArrayList<>();
        this.tipoReparacion = tipoReparacion;
    }
}
