package com.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Mecanico extends Persona {
    private List<Servicio> listaServicios;
    private boolean ocupado;
    private TipoEspecialidad tipoEspecialidad;

    public Mecanico(String id, String nombre,Taller taller,TipoEspecialidad tipoEspecialidad) {
        super(id, nombre,taller);
        this.listaServicios=new ArrayList<>();
        this.tipoEspecialidad = tipoEspecialidad;
        this.ocupado = false;
    }
    public boolean estaDisponible(){
        return !ocupado;
    }
    public void cambiarEstado(boolean estado){
        this.ocupado = estado;
    }
}
