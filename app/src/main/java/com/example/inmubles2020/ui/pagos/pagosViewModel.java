package com.example.inmubles2020.ui.pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.propiedades.Inmuebles;

import java.util.ArrayList;
import java.util.List;

public class pagosViewModel extends ViewModel {
    private MutableLiveData<List<String>> listaDePagos;

    public LiveData<List<String>> getListaDePagos() {
        if(listaDePagos==null){
            listaDePagos=new MutableLiveData<>();
        }
        return listaDePagos;
    }

    public void cargarDatos(){
        ArrayList<Pago> todos=new ArrayList<Pago>();
        ArrayList<String> listado=new ArrayList<String>();
        Pago miPago=new Pago();
        String cadena="";
        for (Pago s : todos = miPago.TraerDatos()) {
            cadena=s.getIdPago()+"-"+s.getIdAlquiler()+" ";
            listado.add(cadena);
        };
        listaDePagos.setValue(listado);
    }
}
