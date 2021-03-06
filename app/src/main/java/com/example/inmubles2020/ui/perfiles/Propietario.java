package com.example.inmubles2020.ui.perfiles;

import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private int propietarioId;
    private int dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    private String clave;
    private int borrado;

   //propietarioId-dni-nombre-apellido-telefono-mail-clave-borrado
    public Propietario() { }

    public Propietario(int propietarioId, int dni, String nombre, String apellido, String telefono, String mail, String clave, int borrado) {
        this.propietarioId = propietarioId;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.clave = clave;
        this.borrado = borrado;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getBorrado() {
        return borrado;
    }

    public void setBorrado(int borrado) {
        this.borrado = borrado;
    }
    /* public List<Propietarios> listarPropietarios() {
        List<Propietarios> listaPropietario = new ArrayList<Propietarios>();
        Propietarios propietario = new Propietarios();
        propietario.idPropietario = 1;
        propietario.dni = 10100100;
        propietario.nombre = "ana";
        propietario.apellido = "acosta";
        propietario.telefono = "2661-001001";
        propietario.mail = "a";//"ana@gmail.com";
        propietario.password = "a";//"111";
        listaPropietario.add(propietario);

        propietario = new Propietarios();
        propietario.idPropietario = 2;
        propietario.dni = 20200200;
        propietario.nombre = "bruno";
        propietario.apellido = "becerra";
        propietario.telefono = "2664-002002";
        propietario.mail = "bruno@gmail.com";
        propietario.password = "222";
        listaPropietario.add(propietario);

        propietario = new Propietarios();
        propietario.idPropietario = 3;
        propietario.dni = 30300300;
        propietario.nombre = "ciro";
        propietario.apellido = "cortéz";
        propietario.telefono = "2664-003003";
        propietario.mail = "ciro@gmail.com";
        propietario.password = "333";
        listaPropietario.add(propietario);

        return listaPropietario;
    }

    public  boolean logueo(String mail, String password){
        boolean rta=false;
        List<Propietarios> listado = new ArrayList<Propietarios>();
        Propietarios propietario = new Propietarios();
        listado=propietario.listarPropietarios();
        for(Propietarios p:listado)
        {
            if(p.mail.equals(mail) && p.password.equals(password))
                rta=true;
        }
        return  rta;
    }
    public  Propietarios devolverPropietario(String mail){
        List<Propietarios> listado = new ArrayList<Propietarios>();
        Propietarios propietario = new Propietarios();
        listado=propietario.listarPropietarios();
        for(Propietarios p:listado)
        {
            if(p.mail.equals(mail))
                propietario=p;
        }
        return  propietario;
    }
    public  Propietarios devolverPorDni(Integer dni){
        List<Propietarios> listado = new ArrayList<Propietarios>();
        Propietarios propietario = new Propietarios();
        listado=propietario.listarPropietarios();
        for(Propietarios p:listado)
        {
            if(p.dni==dni)
                propietario=p;
        }
        return  propietario;
    }
    public  Propietarios devolverPorId(Integer id){
        List<Propietarios> listado = new ArrayList<Propietarios>();
        Propietarios propietario = new Propietarios();
        listado=propietario.listarPropietarios();
        for(Propietarios p:listado)
        {
            if(p.idPropietario==id)
                propietario=p;
        }
        return  propietario;
    }
    public void modificarPropietario(String dn, String apellido, String nombre, String mail, String telefono, String password)
    {
        int dni=Integer.parseInt(dn);
        List<Propietarios> listado = new ArrayList<Propietarios>();
        List<Propietarios> listadoNuevo = new ArrayList<Propietarios>();
        Propietarios propietario = new Propietarios();
        Propietarios otro=new Propietarios();
        listado=propietario.listarPropietarios();
        int i=0;
        int pos=0;
        boolean esta=false;
        for(Propietarios p:listado)
        {
            if(p.dni==dni)
            {
                otro.idPropietario=idPropietario;
                otro.dni=dni;
                otro.apellido=apellido;
                otro.nombre=nombre;
                otro.telefono=telefono;
                otro.mail=mail;
                otro.password=password;
                esta=true;
                listadoNuevo.add(otro);
                esta=true;
            }
            if(!esta) listadoNuevo.add(p);
            esta=false;
        }
        listado=new ArrayList<Propietarios>();
        for(Propietarios p:listadoNuevo)
        {listado.add(p);}


    }*/
  /*  public String modificarPropietario(Propietarios miPropietario)
    {
        String aux="";
        List<Propietarios> listado = new ArrayList<Propietarios>();
        List<Propietarios> listadoNuevo = new ArrayList<Propietarios>();
        Propietarios propietario = new Propietarios();
        Propietarios otro=new Propietarios();
        listado=propietario.listarPropietarios();
        int i=0;
        int pos=0;
        boolean esta=false;
        for(Propietarios p:listado)
        {
            if(p.dni==dni)
            {
                otro.dni=dni;
                otro.apellido=apellido;
                otro.nombre=nombre;
                otro.telefono=telefono;
                otro.mail=mail;
                otro.password=password;
                esta=true;
            }
            listadoNuevo.add(otro);
        }
        if(esta) {
            otro = new Propietarios();
            for (Propietarios p : listadoNuevo) {
                if (p.dni == dni) {
                    otro.dni = p.dni;
                    otro.apellido = p.apellido;
                    otro.nombre = p.nombre;
                    otro.telefono = p.telefono;
                    otro.mail = p.mail;
                    otro.password = p.password;
                }
            }
            aux = "Datos actualizados " + otro.getDni() + "-" + otro.getApellido() + "-" + otro.getNombre() + "-" +
                    otro.getTelefono() + "-" + otro.getMail() + "-" + otro.getPassword();
        }
        else
            aux="El dni "+dni+" no pertenece a un propietario";
        return aux;
    }*/
}
