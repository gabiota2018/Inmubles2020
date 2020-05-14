package com.example.inmubles2020.ui.pagos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.inquilino.Inquilinos;
import com.example.inmubles2020.ui.propiedades.Inmuebles;

import java.util.ArrayList;
import java.util.List;

public class detallePagosViewModel extends ViewModel {
    private MutableLiveData<List<String>> listaDePagos;
    private MutableLiveData<String> tvMensaje;

    public LiveData<List<String>> getListaDePagos() {
        if(listaDePagos==null){
            listaDePagos=new MutableLiveData<>();
        }
        return listaDePagos;
    }
    public LiveData<String> getTvMensaje(){
        if(tvMensaje==null){
            tvMensaje=new MutableLiveData<>();
        }
        return  tvMensaje;
    }

    public void cargarDatos(String palabra){
        Pago miPago=new Pago();
        ArrayList<Pago> listado = new ArrayList<Pago>();
        ArrayList<String> palabras=new ArrayList<String>();

        String[] partes = palabra.split("-");
        Integer part1 =Integer. parseInt(partes[0]);
        listado= miPago.obtenerPorIdAlquiler(part1);

        //obtener direccion
       // Inmuebles miInmueble=new Inmuebles();
        //miInmueble=miInmueble.obtenerPorIdInmueble(part1);

        String cadena="";
        for (Pago s : listado ) {
            cadena="Pago N°"+s.getNroPago()+"-"+s.getFecha()+" $"+s.getImporte();
            palabras.add(cadena);
        };
        listaDePagos.setValue(palabras);
       // tvMensaje.setValue(miInmueble.getDireccion());
        tvMensaje.setValue(partes[1]);
    }
}
