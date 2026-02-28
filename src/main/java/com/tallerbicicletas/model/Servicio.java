package com.tallerbicicletas.model;

import java.time.LocalDate;

public class Servicio {
    private String numeroRegistro;
    private LocalDate fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private String trabajo;
    private double costo;
    private Mecanico mecanico;
    private Taller OwnedByTaller;
    private Bicicleta bicicleta;
    private String repuestosUsados;

    public Servicio(String numeroRegistro,LocalDate fecha, String hora, String motivo, String diagnostico, String trabajo, double costo, Mecanico mecanico, Taller ownedByTaller, Bicicleta bicicleta) {
        this.numeroRegistro=numeroRegistro;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.trabajo = trabajo;
        this.costo = costo;
        this.mecanico = mecanico;
        OwnedByTaller = ownedByTaller;
        this.bicicleta = bicicleta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }
}