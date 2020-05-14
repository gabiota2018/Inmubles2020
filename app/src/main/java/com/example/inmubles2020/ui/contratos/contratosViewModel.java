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

        ArrayList<Inmuebles> todos= new ArrayList<>();
        ArrayList<String> listado=new ArrayList<String>();

        Inmuebles miInmueble=new Inmuebles();
        String cadena="";
       for (Inmuebles s : todos = miInmueble.obtenerAlquilados()) {
            cadena=s.getIdInmueble()+" - "+s.getDireccion();
            listado.add(cadena);
        };
        listaDeContratos.setValue(listado);

    }
}
