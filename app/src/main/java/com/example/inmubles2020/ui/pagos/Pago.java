package com.example.inmubles2020.ui.pagos;

import com.example.inmubles2020.ui.propiedades.Inmuebles;

import java.util.ArrayList;

public class Pago {
    private int idPago;
    private int nroPago;
    private int idAlquiler;
    private String fecha;
    private double importe;

    public Pago() { }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Pago(int idPago, int nroPago, int idAlquiler, String fecha, double importe) {
        this.idPago = idPago;
        this.nroPago = nroPago;
        this.idAlquiler = idAlquiler;//tiene el id del inmueble
        this.fecha = fecha;
        this.importe = importe;
    }
    public ArrayList<Pago> TraerDatos() {
        ArrayList<Pago> listado = new ArrayList<Pago>();

        Pago miPago = new Pago();
        miPago.setIdPago(1);
        miPago.setNroPago(1);
        miPago.setIdAlquiler(1);//id de la casa
        miPago.setFecha("10/1/2020");
        miPago.setImporte(12000);
        listado.add(miPago);

        miPago = new Pago();
        miPago.setIdPago(2);
        miPago.setNroPago(2);
        miPago.setIdAlquiler(1);//id de la casa
        miPago.setFecha("10/2/2020");
        miPago.setImporte(12000);
        listado.add(miPago);

        miPago = new Pago();
        miPago.setIdPago(3);
        miPago.setNroPago(3);
        miPago.setIdAlquiler(1);//id de la casa
        miPago.setFecha("10/3/2020");
        miPago.setImporte(12000);
        listado.add(miPago);

        miPago = new Pago();
        miPago.setIdPago(4);
        miPago.setNroPago(4);
        miPago.setIdAlquiler(1);//id de la casa
        miPago.setFecha("10/4/2020");
        miPago.setImporte(12000);
        listado.add(miPago);

        miPago = new Pago();
        miPago.setIdPago(5);
        miPago.setNroPago(5);
        miPago.setIdAlquiler(1);//id de la casa
        miPago.setFecha("10/5/2020");
        miPago.setImporte(12000);
        listado.add(miPago);


        miPago = new Pago();
        miPago.setIdPago(6);
        miPago.setNroPago(1);
        miPago.setIdAlquiler(3);//id de la casa
        miPago.setFecha("10/3/2020");
        miPago.setImporte(15000);
        listado.add(miPago);

        miPago.setIdPago(7);
        miPago.setNroPago(2);
        miPago.setIdAlquiler(3);//id de la casa
        miPago.setFecha("10/4/2020");
        miPago.setImporte(15000);
        listado.add(miPago);

        miPago.setIdPago(8);
        miPago.setNroPago(3);
        miPago.setIdAlquiler(3);//id de la casa
        miPago.setFecha("10/5/2020");
        miPago.setImporte(15000);
        listado.add(miPago);

        return listado;
    }

    public Pago obtenerPorIdPago(int id){
        ArrayList<Pago> listado = new ArrayList<Pago>();
        Pago miPago=new Pago();
        for (Pago inqui : listado = TraerDatos()) {
            if(inqui.getIdPago()==id)
                miPago=inqui;
        };
        return miPago;
    }
    public ArrayList<Pago> obtenerPorIdAlquiler(int id){
        ArrayList<Pago> listado = new ArrayList<Pago>();
        ArrayList<Pago> listadoPagos = new ArrayList<Pago>();
        Pago miPago=new Pago();
        for (Pago inqui : listado = TraerDatos()) {
            if(inqui.getIdAlquiler()==id)
                listadoPagos.add(inqui);
        };
        return listadoPagos ;
    }
}