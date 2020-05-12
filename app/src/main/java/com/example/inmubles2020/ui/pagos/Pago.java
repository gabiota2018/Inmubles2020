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
        this.idAlquiler = idAlquiler;
        this.fecha = fecha;
        this.importe = importe;
    }
    public ArrayList<Pago> TraerDatos() {
        ArrayList<Pago> listado = new ArrayList<Pago>();

        Pago miPago = new Pago();
        miPago.setIdPago(1);
        miPago.setNroPago(1);
        miPago.setIdAlquiler(1);
        miPago.setFecha("10/2/2020");
        miPago.setImporte(12000);
        listado.add(miPago);

        miPago = new Pago();
        miPago.setIdPago(2);
        miPago.setNroPago(1);
        miPago.setIdAlquiler(2);
        miPago.setFecha("10/4/2020");
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
    public Pago obtenerPorIdAlquiler(int id){
        ArrayList<Pago> listado = new ArrayList<Pago>();
        Pago miPago=new Pago();
        for (Pago inqui : listado = TraerDatos()) {
            if(inqui.getIdAlquiler()==id)
                miPago=inqui;
        };
        return miPago;
    }
}