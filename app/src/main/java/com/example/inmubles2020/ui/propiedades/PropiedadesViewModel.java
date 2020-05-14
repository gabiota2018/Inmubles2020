package com.example.inmubles2020.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.inquilino.Inquilinos;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends ViewModel {
    private MutableLiveData<List<String>> listaDeInmuebles;

    public LiveData<List<String>> getListaDeInmuebles() {
        if(listaDeInmuebles==null){
            listaDeInmuebles=new MutableLiveData<>();
        }
        return listaDeInmuebles;
    }

    public void cargarDatos(){

        ArrayList<Inmuebles> todos=new ArrayList<Inmuebles>();
        ArrayList<String> listado=new ArrayList<String>();
        Inmuebles miInmueble=new Inmuebles();
        String cadena="";
        for (Inmuebles s : todos = miInmueble.TraerDatos()) {
            cadena=s.getIdInmueble()+"-"+s.getDireccion()+" ";
            listado.add(cadena);
        };
        listaDeInmuebles.setValue(listado);
    }
}
