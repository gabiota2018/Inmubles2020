package com.example.inmubles2020.ui.contratos;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.propiedades.Inmuebles;

public class detalleContratosViewModel extends ViewModel {
    private MutableLiveData<String> etIdA;
    private MutableLiveData<String> etPrecioA;
    private MutableLiveData<String> etFechaInicioA;
    private MutableLiveData<String> etFechaFinA;
    private MutableLiveData<String> etInquilino;
    private MutableLiveData<String> etInmueble;

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
    public LiveData<String> etInquilino() {
        if( etInquilino==null){
            etInquilino=new MutableLiveData<>();
        }
        return etInquilino ;
    }
    public LiveData<String> etInmueble() {
        if( etInmueble==null){
            etInmueble =new MutableLiveData<>();
        }
        return etInmueble;
    }
    public void obtenerDatosAlquileres(String palabra){
        Alquileres miAlquiler=new Alquileres();
        String[] partes = palabra.split("-");
        Integer part1 =Integer. parseInt(partes[0]);
        miAlquiler=miAlquiler.obtenerPorIdAlquiler(part1);
        etIdA.setValue(miAlquiler.getIdAlquiler()+"");
        etPrecioA.setValue(miAlquiler.getPrecio()+"");
        etFechaInicioA.setValue(miAlquiler.getFechaInicio());
        etFechaFinA.setValue(miAlquiler.getFechaFin());
        etInquilino.setValue(miAlquiler.getIdInquilino()+"");//buscar nombre y telefono
        etInmueble.setValue(miAlquiler.getIdInmueble()+"");//buscar la direccion

    }
}
