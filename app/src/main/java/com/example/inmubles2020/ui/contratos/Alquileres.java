package com.example.inmubles2020.ui.contratos;

import com.example.inmubles2020.ui.perfiles.Propietarios;
import com.example.inmubles2020.ui.propiedades.Inmuebles;
import com.example.inmubles2020.ui.inquilino.Inquilinos;

import java.util.ArrayList;
import java.util.Date;

public class Alquileres {
    private  int idAlquiler;
    private  double precio;
    private String fechaInicio;
    private String fechaFin;
    private int miInquilino;
    private int miInmueble;

    private String nombreInquilino;
    private String direccion;

    public Alquileres() { }

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

    public int getMiInquilino() {
        return miInquilino;
    }

    public void setMiInquilino(int miInquilino) {
        this.miInquilino = miInquilino;
    }

    public int getMiInmueble() {
        return miInmueble;
    }

    public void setMiInmueble(int miInmueble) {
        this.miInmueble = miInmueble;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public ArrayList<Alquileres> TraerDatos() {
        ArrayList<Alquileres> listado = new ArrayList<Alquileres>();

        Alquileres miAlquiler = new Alquileres();
        miAlquiler.setIdAlquiler(1);
        miAlquiler.setPrecio(12000);
        miAlquiler.setFechaInicio("10/1/2020");
        miAlquiler.setFechaFin("10/1/2022");
        miAlquiler.setMiInquilino(1);
        miAlquiler.setNombreInquilino("María Martinez");
        miAlquiler.setMiInmueble(1);
        miAlquiler.setDireccion("Mar del Plata 245");
        listado.add(miAlquiler);

        miAlquiler = new Alquileres();
        miAlquiler.setIdAlquiler(3);
        miAlquiler.setPrecio(13500);
        miAlquiler.setFechaInicio("10/3/2020");
        miAlquiler.setFechaFin("10/3/2023");
        miAlquiler.setMiInquilino(1);
        miAlquiler.setNombreInquilino("Felicitas Ramirez");
        miAlquiler.setMiInmueble(3);
        miAlquiler.setDireccion("Pringles 123");
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
            if(inqui.getMiInmueble()==id)
            { miAlquiler=inqui;}
        };
        return miAlquiler;
    }

}
