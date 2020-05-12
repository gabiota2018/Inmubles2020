package com.example.inmubles2020.ui.perfiles;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PerfilesViewModel extends ViewModel {
    private MutableLiveData<String> dni;
    private MutableLiveData<String> apellido;
    private MutableLiveData<String> nombre;
    private MutableLiveData<String> telefono;
    private MutableLiveData<String> mail;
    private MutableLiveData<String> password;

    public LiveData<String> getDni() {
        if(dni==null){
            dni=new MutableLiveData<>();
        }
        return dni;
    }

    public LiveData<String> getApellido() {
        if(apellido==null){
            apellido=new MutableLiveData<>();
        }
        return apellido;
    }
    public LiveData<String> getNombre() {
        if(nombre==null){
           nombre=new MutableLiveData<>();
        }
        return nombre;
    }
    public LiveData<String> getTelefono() {
        if(telefono==null){
           telefono=new MutableLiveData<>();
        }
        return telefono;
    }
    public LiveData<String> getMail() {
        if(mail==null){
           mail=new MutableLiveData<>();
        }
        return mail;
    }
    public LiveData<String> getPassword() {
        if(password==null){
           password=new MutableLiveData<>();
        }
        return password;
    }
    public void obtenerDatos(int dniBuscado){
        Propietarios miPropietario=new Propietarios();
        miPropietario=miPropietario.devolverPorDni(dniBuscado);
        apellido.setValue(miPropietario.getApellido());
        dni.setValue(miPropietario.getDni()+"");
        nombre.setValue(miPropietario.getNombre());
        telefono.setValue(miPropietario.getTelefono());
        mail.setValue(miPropietario.getMail());
        password.setValue(miPropietario.getPassword());
    }

public void actualizar(){}
    /*public void actualizar(String dni, String apellido, String nombre, String mail, String telefono, String password) {
        Propietarios miPropietario=new Propietarios();
        miPropietario.modificarPropietario(dni,apellido,nombre,mail,telefono,password);
    }*/
}
