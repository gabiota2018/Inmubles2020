package com.example.inmubles2020.ui.propiedades;


import java.util.ArrayList;


public class Inmuebles {
   private int inmuebleId;
   private String direccion;
   private int ambientes;
   private String tipo;
   private String uso;
   private  double precio;
   private  int disponible;
   private String miDuenio;
   //private perfiles.Propietarios propietario;

    public Inmuebles(){}

    //---------------------------------------------------------
    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    //---------------------------------------------------------
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //---------------------------------------------------------
    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }
    //---------------------------------------------------------
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //---------------------------------------------------------
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //---------------------------------------------------------
    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

   //---------------------------------------------------------

    public String getMiDuenio() {
        return miDuenio;
    }

    public void setMiDuenio(String miDuenio) {
        this.miDuenio = miDuenio;
    }
    //---------------------------------------------------------

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    //---------------------------------------------------------
    public ArrayList<Inmuebles> TraerDatos() {
        ArrayList<Inmuebles> listado = new ArrayList<Inmuebles>();

         Inmuebles miInmueble = new Inmuebles();
        miInmueble.setInmuebleId(1);
        miInmueble.setDireccion("Mar del Plata 245");
        miInmueble.setAmbientes(5);
        miInmueble.setUso("Vivienda");
        miInmueble.setTipo("Casa");
        miInmueble.setPrecio(12000);
        miInmueble.setDisponible(0);

        listado.add(miInmueble);

        miInmueble = new Inmuebles();
        miInmueble.setInmuebleId(2);
        miInmueble.setDireccion("Lic1 Mz2 Cs3");
        miInmueble.setAmbientes(2);
        miInmueble.setUso("Comercial");
        miInmueble.setTipo("Local");
        miInmueble.setPrecio(20000);
        miInmueble.setDisponible(1);

        listado.add(miInmueble);

        miInmueble = new Inmuebles();
        miInmueble.setInmuebleId(3);
        miInmueble.setDireccion("Pringles 123 Planta Baja A");
        miInmueble.setAmbientes(3);
        miInmueble.setUso("Oficina");
        miInmueble.setTipo("Departamento");
        miInmueble.setPrecio(13500);
        miInmueble.setDisponible(0);

        listado.add(miInmueble);
        return listado;
    }

    public Inmuebles obtenerPorIdInmueble(int id){
        ArrayList<Inmuebles> listado = new ArrayList<Inmuebles>();
        Inmuebles miInmueble=new Inmuebles();
        for (Inmuebles inqui : listado = TraerDatos()) {
            if(inqui.getInmuebleId()==id)
               miInmueble=inqui;
        };
        return miInmueble;
    }
    public ArrayList<Inmuebles> obtenerAlquilados(){
        ArrayList<Inmuebles> listado = new ArrayList<Inmuebles>();
        ArrayList<Inmuebles> listadoAlquilados = new ArrayList<Inmuebles>();
        Inmuebles miInmueble=new Inmuebles();
        for (Inmuebles inqui : listado = TraerDatos()) {
            if(inqui.getDisponible()==0)
                listadoAlquilados.add(inqui);
        };
        return listadoAlquilados;
    }


  /*  public Inmuebles obtenerPorIdDuenio(int id){
        ArrayList<Inmuebles> listado = new ArrayList<Inmuebles>();
        Inmuebles miInmueble=new Inmuebles();
        Propietarios miPropietario=new Propietarios();
        for (Inmuebles inqui : listado = TraerDatos()) {
            miPropietario=inqui.getMiDuenio();
            if(miPropietario.getIdPropietario()==id)
                miInmueble=inqui;
        };
        return miInmueble;
    }*/

}
