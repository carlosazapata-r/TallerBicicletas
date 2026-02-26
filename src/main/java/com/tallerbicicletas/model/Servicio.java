package com.tallerbicicletas.model;

import java.time.LocalDate;

public class Servicio {

    private LocalDate fecha;
    private String motivo;
    private String diagnostico;
    private String trabajo;
    private double costo;

    private Bicicleta bicicleta;
    private Cliente cliente;
    private Mecanico mecanico;
    private TipoReparacion tipoReparacion;

    public Servicio(LocalDate fecha, String motivo, String diagnostico, String trabajo,
                    double costo, Bicicleta bicicleta, Cliente cliente,
                    Mecanico mecanico, TipoReparacion tipoReparacion) {

        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.trabajo = trabajo;
        this.costo = costo;
        this.bicicleta = bicicleta;
        this.cliente = cliente;
        this.mecanico = mecanico;
        this.tipoReparacion = tipoReparacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public double getCosto() {
        return costo;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public TipoReparacion getTipoReparacion() {
        return tipoReparacion;
    }
}