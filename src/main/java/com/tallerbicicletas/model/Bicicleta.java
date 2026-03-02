package com.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Bicicleta {

    private String color;
    private String marca;
    private String numeroSerie;
    private TipoBicicleta tipo;
    private List<Servicio> listaServicios;
    private int año;
    private Taller taller;
    private Cliente cliente;

    public Bicicleta(String color, String marca, String numeroSerie, TipoBicicleta tipo,int año,Taller taller,Cliente cliente) {
        this.color = color;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
        this.listaServicios = new ArrayList<>();
        this.año = año;
        this.cliente= cliente;
        this.taller = taller;
    }
    

    public String getNumeroSerie() {
        return numeroSerie;
    }
    /**
     * Metodo para asociar un servicio con una bicicleta
     * @param servicio
     * @return
     */
    public void agregarServicio(Servicio servicio) {
        if(servicio != null){
            listaServicios.add(servicio);
        }
    }
    /**
     * Metodo para obtener el historial de servicios de una bicicleta
     * @return
     */
    public List<Servicio> obtenerHistorialServicios(){
        return listaServicios;
    }
}
