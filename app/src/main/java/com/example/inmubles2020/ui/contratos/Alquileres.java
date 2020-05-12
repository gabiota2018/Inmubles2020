package com.example.inmubles2020.ui.contratos;

import com.example.inmubles2020.ui.propiedades.Inmuebles;

import java.util.ArrayList;
import java.util.Date;

public class Alquileres {
    private  int idAlquiler;
    private  double precio;
    private String fechaInicio;
    private String fechaFin;
    private int idInquilino;
    private int idInmueble;

    public Alquileres() { }

    public Alquileres(int idAlquiler, double precio, String fechaInicio, String fechaFin, int idInquilino, int idInmueble) {
        this.idAlquiler = idAlquiler;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idInquilino = idInquilino;
        this.idInmueble = idInmueble;
    }


    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public ArrayList<Alquileres> TraerDatos() {
        ArrayList<Alquileres> listado = new ArrayList<Alquileres>();

        Alquileres miAlquiler = new Alquileres();
        miAlquiler.setIdAlquiler(1);
        miAlquiler.setPrecio(12000);
        miAlquiler.setFechaInicio("10/1/2020");
        miAlquiler.setFechaFin("10/1/2022");
        miAlquiler.setIdInquilino(1);
        miAlquiler.setIdInmueble(1);
        listado.add(miAlquiler);

        miAlquiler = new Alquileres();
        miAlquiler.setIdAlquiler(2);
        miAlquiler.setPrecio(15000);
        miAlquiler.setFechaInicio("10/3/2020");
        miAlquiler.setFechaFin("10/3/2023");
        miAlquiler.setIdInquilino(2);
        miAlquiler.setIdInmueble(3);
        listado.add(miAlquiler);

        return listado;
    }
    public Alquileres obtenerPorIdAlquiler(int id){
        ArrayList<Alquileres> listado = new ArrayList<Alquileres>();
        Alquileres miAlquiler=new Alquileres();
        for (Alquileres inqui : listado = TraerDatos()) {
            if(inqui.getIdAlquiler()==id)
                miAlquiler=inqui;
        };
        return miAlquiler;
    }
    public Alquileres obtenerPorIdInmueble(int id){
        ArrayList<Alquileres> listado = new ArrayList<Alquileres>();
        Alquileres miAlquiler=new Alquileres();
        for (Alquileres inqui : listado = TraerDatos()) {
            if(inqui.getIdInmueble()==id)
                miAlquiler=inqui;
        };
        return miAlquiler;
    }
    /*public Alquileres obtenerPorIdDuenio(int id){
        ArrayList<Alquileres> listado = new ArrayList<Alquileres>();
        Alquileres miAlquiler=new Alquileres();
        for (Alquileres inqui : listado = TraerDatos()) {
            if(inqui.getIdInmueble()==id)
                miAlquiler=inqui;
        };
        return miAlquiler;
    }*/
}
