package com.example.inmubles2020.ui.contratos;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.inquilino.Inquilinos;
import com.example.inmubles2020.ui.propiedades.Inmuebles;

import java.util.ArrayList;

public class detalleContratosViewModel extends ViewModel {
    private MutableLiveData<String> etIdA;
    private MutableLiveData<String> etPrecioA;
    private MutableLiveData<String> etFechaInicioA;
    private MutableLiveData<String> etFechaFinA;

    public LiveData<String> etIdA() {
        if(etIdA==null){
            etIdA=new MutableLiveData<>();
        }
        return etIdA;
    }
    public LiveData<String> etPrecioA() {
        if(etPrecioA ==null){
            etPrecioA =new MutableLiveData<>();
        }
        return etPrecioA ;
    }
    public LiveData<String> etFechaInicioA() {
        if(etFechaInicioA ==null){
            etFechaInicioA=new MutableLiveData<>();
        }
        return etFechaInicioA ;
    }
    public LiveData<String> etFechaFinA() {
        if( etFechaFinA==null){
            etFechaFinA=new MutableLiveData<>();
        }
        return etFechaFinA;
    }

    public void obtenerDatosAlquileres(String palabra)//por id de inmueble.....
    {
        //Alquileres miAlquiler=new Alquileres();
        Alquileres miAlquiler=new Alquileres();
        String[] partes = palabra.split("-");
        Integer part1 =Integer. parseInt(partes[0]);

        miAlquiler=miAlquiler.obtenerPorIdInmueble(part1);
        etIdA.setValue(miAlquiler.getDireccion());
        etFechaInicioA.setValue("Inicio: "+ miAlquiler.getFechaInicio());
        etFechaFinA.setValue("Finaliza: "+miAlquiler.getFechaFin());
        etPrecioA.setValue("Cuota: "+miAlquiler.getPrecio()+"");

    }
}
