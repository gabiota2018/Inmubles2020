package com.example.inmubles2020.ui.propiedades;

import com.example.inmubles2020.ui.inquilino.Inquilinos;
import com.example.inmubles2020.ui.perfiles.Propietarios;
import com.example.inmubles2020.ui.perfiles.perfiles;

import java.util.ArrayList;


public class Inmuebles {
   private int idInmueble;
   private String direccion;
   private int ambientes;
   private String tipo;
   private String uso;
   private  double precio;
   private  int disponible;
   private int idDuenio;
   //private perfiles.Propietarios propietario;

    public Inmuebles(){}
    public Inmuebles(int idInmueble,String direccion, int ambientes,String tipo, double precio,int disponible,String uso,int idDuenio ){
        this.idInmueble=idInmueble;
        this.direccion=direccion;
        this.ambientes=ambientes;
        this.tipo=tipo;
        this.uso=uso;
        this.precio=precio;
        this.disponible=disponible;
        this.idDuenio=idDuenio;
        //this.perfiles.Propietario=propietario;
    }
    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getIdDuenio() { return idDuenio; }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    public String getUso() { return uso; }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public ArrayList<Inmuebles> TraerDatos() {
        ArrayList<Inmuebles> listado = new ArrayList<Inmuebles>();

        Inmuebles miInmueble = new Inmuebles();
        miInmueble.setIdInmueble(1);
        miInmueble.setDireccion("Mar del Plata 245");
        miInmueble.setAmbientes(5);
        miInmueble.setTipo("vivienda");
        miInmueble.setPrecio(12000);
        miInmueble.setDisponible(0);
        miInmueble.setIdDuenio(1);

        listado.add(miInmueble);

        miInmueble = new Inmuebles();
        miInmueble.setIdInmueble(2);
        miInmueble.setDireccion("Lic1 Mz2 Cs3");
        miInmueble.setAmbientes(2);
        miInmueble.setTipo("local");
        miInmueble.setPrecio(20000);
        miInmueble.setDisponible(1);
        miInmueble.setIdDuenio(1);

        listado.add(miInmueble);

        miInmueble = new Inmuebles();
        miInmueble.setIdInmueble(3);
        miInmueble.setDireccion("Pringles 123");
        miInmueble.setAmbientes(3);
        miInmueble.setTipo("vivienda");
        miInmueble.setPrecio(13500);
        miInmueble.setDisponible(0);
        miInmueble.setIdDuenio(2);

        listado.add(miInmueble);
        return listado;
    }

    public Inmuebles obtenerPorIdInmueble(int id){
        ArrayList<Inmuebles> listado = new ArrayList<Inmuebles>();
        Inmuebles miInmueble=new Inmuebles();
        for (Inmuebles inqui : listado = TraerDatos()) {
            if(inqui.getIdInmueble()==id)
               miInmueble=inqui;
        };
        return miInmueble;
    }
    public Inmuebles obtenerPorIdDuenio(int id){
        ArrayList<Inmuebles> listado = new ArrayList<Inmuebles>();
        Inmuebles miInmueble=new Inmuebles();
        for (Inmuebles inqui : listado = TraerDatos()) {
            if(inqui.getIdDuenio()==id)
                miInmueble=inqui;
        };
        return miInmueble;
    }

}
