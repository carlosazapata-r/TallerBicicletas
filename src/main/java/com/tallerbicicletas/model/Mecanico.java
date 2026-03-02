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
    /**
     * Metodo para mirar si el mecanico esta disponible
     * @return
     */
    public boolean estaDisponible(){
        return !ocupado;
    }
    /**
     * Metodo para cambiar el estado del mecanico a disponible o ocupado
     * @param estado
     * @return
     */
    public void cambiarEstado(boolean estado){
        this.ocupado = estado;
    }
}
