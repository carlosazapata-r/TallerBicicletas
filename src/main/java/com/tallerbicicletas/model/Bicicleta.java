package com.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Bicicleta {

    private String color;
    private String marca;
    private String nombreSerie;
    private TipoBicicleta tipo;
    private List<Servicio> listaServicios;
    private String año;
    private Taller taller;
    private Cliente cliente;

    public Bicicleta(String color, String marca, String nombreSerie, TipoBicicleta tipo,String año,Taller taller,Cliente cliente) {
        this.color = color;
        this.marca = marca;
        this.nombreSerie = nombreSerie;
        this.tipo = tipo;
        this.listaServicios = new ArrayList<>();
        this.año = año;
        this.cliente= cliente;
        this.taller = taller;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    public void agregarServicio(Servicio servicio) {
        if(servicio != null){
            listaServicios.add(servicio);
        }
    }
    public List<Servicio> obtenerHistorialServicios(){
        return listaServicios;
    }
}
