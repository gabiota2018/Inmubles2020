package com.example.inmubles2020.ui.inquilino;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class InquilinoViewModel extends ViewModel {
    private MutableLiveData<List<String>> listaDeInquilinos;

    public LiveData<List<String>> getListaDeInquilinos() {
        if(listaDeInquilinos==null){
            listaDeInquilinos=new MutableLiveData<>();
        }
        return listaDeInquilinos;
    }


    public void cargarDatos(){

        ArrayList<Inquilinos> todos=new ArrayList<Inquilinos>();
        ArrayList<String> palabras=new ArrayList<String>();
        Inquilinos miInquilino=new Inquilinos();
        String cadena="";
        //todos=miInquilino.obtenerInquilinosActuales();
        todos=miInquilino.obtenerInquilinosActuales();
        for (Inquilinos s : todos ) {
            cadena=s.getIdInquilino()+"-"+s.getApellido()+" "+s.getNombre();
            palabras.add(cadena);
        };
        listaDeInquilinos.setValue(palabras);
    }
}
