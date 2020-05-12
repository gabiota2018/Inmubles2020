package com.example.inmubles2020.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.propiedades.Inmuebles;

import java.util.ArrayList;
import java.util.List;

public class contratosViewModel extends ViewModel {

    private MutableLiveData<List<String>> listaDeContratos;

    public LiveData<List<String>> getListaDeContratos() {
        if(listaDeContratos==null){
            listaDeContratos=new MutableLiveData<>();
        }
        return listaDeContratos;
    }

    public void cargarDatos(){

        ArrayList<Alquileres> todos=new ArrayList<Alquileres>();
        ArrayList<String> listado=new ArrayList<String>();
        Alquileres miAlquiler=new Alquileres();
        String cadena="";
        for (Alquileres s : todos = miAlquiler.TraerDatos()) {
           //la direccion del obj.inmueble
            cadena=s.getIdAlquiler()+"-"+"Pringles 248"+" ";
            listado.add(cadena);
        };
        listaDeContratos.setValue(listado);

    }
}
