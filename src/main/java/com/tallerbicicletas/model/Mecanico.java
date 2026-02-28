package com.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Mecanico extends Persona {
    private List<Servicio> listaServicios;
    private TipoEspecialidad tipoEspecialidad;

    public Mecanico(String id, String nombre,Taller taller,TipoEspecialidad tipoEspecialidad) {
        super(id, nombre,taller);
        this.listaServicios=new ArrayList<>();
        this.tipoEspecialidad = tipoEspecialidad;
    }
}
