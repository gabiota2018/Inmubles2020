package com.example.inmubles2020.ui.inquilino;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetalleInquilinoViewModel extends ViewModel {

    private MutableLiveData<String> idInq;
    private MutableLiveData<String> apellidoInq;
    private MutableLiveData<String> nonbreInq;
    private MutableLiveData<String> dniInq;
    private MutableLiveData<String>  telefonoInq;
    private MutableLiveData<String> direccionInq;

    public LiveData<String> getIdInq() {
        if(idInq==null){
            idInq=new MutableLiveData<>();
        }
        return idInq;
    }

    public LiveData<String> getApellidoInq() {
        if(apellidoInq==null){
            apellidoInq=new MutableLiveData<>();
        }
        return apellidoInq;
    }
    public LiveData<String> getNombreInq() {
        if(nonbreInq==null){
            nonbreInq=new MutableLiveData<>();
        }
        return nonbreInq;
    }
    public LiveData<String> getDniInq() {
        if(dniInq==null){
            dniInq=new MutableLiveData<>();
        }
        return dniInq;
    }
    public LiveData<String> getTelefonoInq() {
        if(telefonoInq==null){
            telefonoInq=new MutableLiveData<>();
        }
        return telefonoInq;
    }
    public LiveData<String> getDireccionInq() {
        if(direccionInq==null){
            direccionInq=new MutableLiveData<>();
        }
        return direccionInq;
    }

    public void obtenerDatosInquilino(String palabra){
        Inquilinos miInquilino=new Inquilinos();
        String[] partes = palabra.split("-");
        Integer part1 =Integer. parseInt(partes[0]);
        miInquilino=miInquilino.obtenerPorId(part1);
        apellidoInq.setValue(miInquilino.getApellido());
        idInq.setValue("N° "+ miInquilino.getIdInquilino()+"");
        nonbreInq.setValue(miInquilino.getNombre());
        dniInq.setValue("DNI: "+miInquilino.getDni()+"");
        telefonoInq.setValue("Teléfono: "+miInquilino.getTelefono());
        direccionInq.setValue("Domicilio: "+miInquilino.getDireccion());
    }


}
