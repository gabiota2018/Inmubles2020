package com.example.inmubles2020.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.inquilino.Inquilinos;

public class detallePropiedaesViewModel extends ViewModel {

    private MutableLiveData<String> etDireccionP;
    private MutableLiveData<String> etAmbienteP;
    private MutableLiveData<String> etTipoP;
    private MutableLiveData<String> etUsoP;
    private MutableLiveData<String> etPrecioP;

    private MutableLiveData<Boolean> cbDisponibleP;
    private MutableLiveData<String>  tvIdP;
    private MutableLiveData<String>  tvIdDuenioP;

    public LiveData<String> etDireccionP() {
        if(etDireccionP==null){
            etDireccionP=new MutableLiveData<>();
        }
        return etDireccionP;
    }
    public LiveData<String> etAmbienteP() {
        if(etAmbienteP==null){
            etAmbienteP=new MutableLiveData<>();
        }
        return etAmbienteP;
    }
    public LiveData<String> etTipoP() {
        if(etTipoP==null){
            etTipoP=new MutableLiveData<>();
        }
        return etTipoP;
    }
    public LiveData<String> etUsoP() {
        if(etUsoP==null){
            etUsoP=new MutableLiveData<>();
        }
        return etUsoP;
    }
    public LiveData<String> etPrecioP() {
        if(etPrecioP==null){
            etPrecioP=new MutableLiveData<>();
        }
        return etPrecioP;
    }
    public MutableLiveData<Boolean> cbDisponibleP() {
        if(cbDisponibleP==null){
            cbDisponibleP=new MutableLiveData<>();
        }
        return cbDisponibleP;
    }
    public MutableLiveData<String> tvIdP() {
        if(tvIdP==null){
            tvIdP=new MutableLiveData<>();
        }
        return tvIdP;
    }
    public MutableLiveData<String> tvIdDuenioP() {
        if(tvIdDuenioP==null){
            tvIdDuenioP=new MutableLiveData<>();
        }
        return tvIdDuenioP;
    }
    public void obtenerDatosInmuebles(String palabra){
        Inmuebles miInmuebles=new Inmuebles();
        String[] partes = palabra.split("-");
        Integer part1 =Integer. parseInt(partes[0]);
        miInmuebles=miInmuebles.obtenerPorIdInmueble(part1);
        tvIdP.setValue(miInmuebles.getIdInmueble()+"");
        etDireccionP.setValue(miInmuebles.getDireccion());
        etAmbienteP.setValue(miInmuebles.getAmbientes()+"");
        etTipoP.setValue(miInmuebles.getTipo());
        etUsoP.setValue(miInmuebles.getUso());
        etPrecioP.setValue(miInmuebles.getPrecio()+"");
        tvIdDuenioP.setValue(miInmuebles.getIdDuenio()+"");
        if(miInmuebles.getDisponible()==1)
          cbDisponibleP.setValue(true);
        else
          cbDisponibleP.setValue(false);
    }
}
