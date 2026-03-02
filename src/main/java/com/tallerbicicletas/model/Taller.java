package com.tallerbicicletas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Taller {

    private int id;
    private String nombre;
    private String telefono;

    private List<Bicicleta> listaBicicletas;
    private List<Persona> listaPersonas;
    private List<Servicio> listaServicios;

    public Taller(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.listaBicicletas = new ArrayList<>();
        this.listaPersonas = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
    }
    /**
     * Metodo para buscar si ya hay un cliente registrado
     * @param id
     * @return
     */
    public Persona buscarCliente(String id){
        for (Persona p : listaPersonas) {
            if (p instanceof Cliente && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    /**
     * Metodo para registrar a un cliente
     * @param nombre
     * @param id
     * @param direccion
     * @param tel
     */
    public void registrarCliente(String nombre,String id,String direccion,String tel){
        if(buscarCliente(id)==null){
            Cliente nuevoCliente = new Cliente(
                    id,
                    nombre,
                    this,
                    direccion,
                    tel
            );

            listaPersonas.add(nuevoCliente);

            System.out.println("Cliente registrado correctamente.");
        }else{
            System.out.println("Cliente ya esta registrado");
        }
    }
    /**
     * Metodo para buscar si una bicicleta ya esta registrada
     * @param numeroSerie
     * @return
     */
    public Bicicleta buscarBicicleta(String numeroSerie){
        for (Bicicleta p : listaBicicletas) {
            if (p.getNumeroSerie().equals(numeroSerie)) {
                return p;
            }
        }
        return null;
    }
    /**
     * Metodo para registrar a una bicicleta
     * @param color
     * @param marca
     * @param numeroSerie
     * @param tipo
     * @param año
     * @param taller
     * @param cliente
     */
    public void registrarBicicletas(String color, String marca, String numeroSerie, TipoBicicleta tipo,int año,Taller taller,Cliente cliente){
        if(buscarBicicleta(numeroSerie)==null){
            Bicicleta nuevaBicicleta = new Bicicleta(
                    color,
                    marca,
                    numeroSerie,
                    tipo,
                    año,
                    taller,
                    cliente
            );
            cliente.agregarBicicleta(nuevaBicicleta);

            listaBicicletas.add(nuevaBicicleta);

            System.out.println("La bicicleta fue registrada correctamente.");
        }else{
            System.out.println("La bicicleta ya esta registrada");
        }
    }
    /**
     * Metodo para buscar si un mecanico ya esta registrado
     * @param id
     * @return
     */
    public Persona buscarMecanico(String id){
        for (Persona p : listaPersonas) {
            if (p instanceof Mecanico && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    /**
     * Metodo para registrar un mecanico al sistema
     * @param id
     * @param nombre
     * @param taller
     * @param tipoEspecialidad
     */
    public void registrarMecanico(String id, String nombre, Taller taller,TipoEspecialidad tipoEspecialidad){
        if(buscarMecanico(id)==null){
            Mecanico nuevoMecanico = new Mecanico(
                    id,
                    nombre,
                    this,
                    tipoEspecialidad
            );

            listaPersonas.add(nuevoMecanico);

            System.out.println("Mecanico registrado correctamente.");
        }else{
            System.out.println("Mecanico ya esta registrado");
        }
    }
    /**
     * Metodo para buscar si ya esta registrado un servicio
     * @param numeroRegistro
     * @return
     */
    public Servicio buscarOrdenServicio(String numeroRegistro){
        for (Servicio s : listaServicios) {
            if (s.getNumeroRegistro().equals(numeroRegistro)) {
                return s;
            }
        }
        return null;
    }
    /**
     * Metodo para registrar orden de servicio
     * @param numeroRegistro
     * @param fecha
     * @param hora
     * @param motivo
     * @param diagnostico
     * @param trabajo
     * @param costo
     * @param mecanico
     * @param ownedByTaller
     * @param bicicleta
     */
    public void registrarOrdenServicio(String numeroRegistro, LocalDate fecha, String hora, String motivo, String diagnostico, String trabajo, double costo, Mecanico mecanico, Taller ownedByTaller, Bicicleta bicicleta){
        if(buscarOrdenServicio(numeroRegistro)==null){
            Servicio nuevoServicio = new Servicio(
                    numeroRegistro,
                    fecha,
                    hora,
                    motivo,
                    diagnostico,
                    trabajo,
                    costo,
                    mecanico,
                    ownedByTaller,
                    bicicleta
            );

            listaServicios.add(nuevoServicio);
            bicicleta.agregarServicio(nuevoServicio);
            System.out.println("El servicio fue registrado correctamente.");
        }else{
            System.out.println("El servicio ya esta registrado.");
        }
    }
    /**
     * Metodo para obtener los servicios registrados en un fecha en especifico
     * @param fecha
     * @return
     */

    public List<Servicio> obtenerOrdenFecha(LocalDate fecha){
        List<Servicio> listaFecha= new ArrayList();
        for(Servicio s:listaServicios){
            if(s.getFecha().equals(fecha)){
                listaFecha.add(s);
            }
        }
        return listaFecha;
    }
    /**
     * Metodo para obtener el historial del servicio de una bicicleta
     * @param numeroSerie
     * @return
     */

    public List<Servicio> obtenerHistorialBicicleta(String numeroSerie){
        Bicicleta bici = buscarBicicleta(numeroSerie);
        if(bici != null){
            return bici.obtenerHistorialServicios();
        }
        return new ArrayList<>();
    }
}
