package com.example.inmubles2020.ui.inquilino;

import java.util.ArrayList;
import java.util.List;

public class Inquilinos {
    private int idInquilino;
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    private String password;


    public Inquilinos () { }
    public Inquilinos(int idInquilino, int dni, String nombre, String apellido, String direccion,String telefono)
    {
        this.idInquilino = idInquilino;
        this.dni=dni;//no se puede cambiar
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion=direccion;
        this.telefono = telefono;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino=idInquilino;
    }
    public int getIdInquilino() {
        return idInquilino;
    }

    public void setDni(int dni) {
        this.dni=dni;
    }
    public int getDni() {
        return dni;
    }

    public void setNombre (String nombre) { this.nombre = nombre;    }
    public String getNombre() {
        return nombre;
    }

    public void setApellido (String apellido) {
        this.apellido= apellido;
    }
    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion (String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono (String telefono){
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Inquilinos> TraerDatos() {
        ArrayList<Inquilinos> palabras = new ArrayList<Inquilinos>();

        Inquilinos miInquilino = new Inquilinos();
        miInquilino.setIdInquilino(1);
        miInquilino.setDni(21211211);
        miInquilino.setNombre("María");
        miInquilino.setApellido("Martinez");
        miInquilino.setDireccion("Mar del Plata 245");
        miInquilino.setTelefono("2664-110022");
        palabras.add(miInquilino);

        miInquilino = new Inquilinos();
        miInquilino.setIdInquilino(2);
        miInquilino.setDni(30222000);
        miInquilino.setNombre("Juan");
        miInquilino.setApellido("Luna");
        miInquilino.setDireccion("Pringles 23");
        miInquilino.setTelefono("2664-223344");
        palabras.add(miInquilino);

        miInquilino = new Inquilinos();
        miInquilino.setIdInquilino(3);
        miInquilino.setDni(30333000);
        miInquilino.setNombre("Felicitas");
        miInquilino.setApellido("Ramírez");
        miInquilino.setDireccion("Mod 8 Mz 4 Cs 3");
        miInquilino.setTelefono("2664-333000");
        palabras.add(miInquilino);
        return palabras;
    }
public Inquilinos obtenerPorId(int id){
    ArrayList<Inquilinos> palabras = new ArrayList<Inquilinos>();
    Inquilinos miInquilino=new Inquilinos();
    for (Inquilinos inqui : palabras = TraerDatos()) {
        if(inqui.getIdInquilino()==id)
            miInquilino=inqui;
    };


    return miInquilino;
}
}
