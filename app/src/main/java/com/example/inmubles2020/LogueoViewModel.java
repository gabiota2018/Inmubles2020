package com.example.inmubles2020;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.perfiles.Propietarios;

public class LogueoViewModel extends ViewModel {
    private MutableLiveData<String> etUsuario;
    private MutableLiveData<String> etPassword;
    private MutableLiveData<String>  tvMensaje;

    public LiveData<String> getEtUsuario() {
        if(etUsuario==null){
            etUsuario=new MutableLiveData<>();
        }
        return etUsuario;
    }
    public LiveData<String> getEtPassword() {
        if(etPassword==null){
            etPassword=new MutableLiveData<>();
        }
        return etPassword;
    }
    public LiveData<String> getTvMensaje() {
        if(tvMensaje==null){
            tvMensaje=new MutableLiveData<>();
        }
        return tvMensaje;
    }
    public  Boolean logueo(String usuario,String password){
        Propietarios miPropietario=new Propietarios();
        boolean rta=miPropietario.logueo(usuario,password);
        if(!rta) tvMensaje.setValue("Datos incorrectos");
        return  rta;
    }
}
