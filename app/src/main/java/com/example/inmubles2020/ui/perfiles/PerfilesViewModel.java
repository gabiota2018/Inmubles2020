package com.example.inmubles2020.ui.perfiles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilesViewModel extends AndroidViewModel {
    private MutableLiveData<String> dni;
    private MutableLiveData<String> apellido;
    private MutableLiveData<String> nombre;
    private MutableLiveData<String> telefono;
    private MutableLiveData<String> mail;
    private MutableLiveData<String> password;
    private MutableLiveData<Propietarios> propietarioMutableLiveData;
    private Context context;

    public PerfilesViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<Propietarios> getPropietarioMutableLiveData(){
        if(propietarioMutableLiveData==null){
            propietarioMutableLiveData=new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
    }
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

    public void obtenerDatos(){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Propietarios> propietarioCall= ApiClient.getMyApiClient().obtenerDatos(accessToken);
        propietarioCall.enqueue(new Callback<Propietarios>() {
            @Override
            public void onResponse(Call<Propietarios> call, Response<Propietarios> response) {
                if(response.isSuccessful()){
                    Propietarios miPropietario=response.body();
                    apellido.setValue(miPropietario.getApellido());
                    dni.setValue("DNI: "+miPropietario.getDni()+"");
                    nombre.setValue(miPropietario.getNombre());
                    telefono.setValue("Teléfono: "+miPropietario.getTelefono());
                    mail.setValue("Email: "+miPropietario.getMail());
                    password.setValue("Password: "+miPropietario.getClave());
                    propietarioMutableLiveData.postValue(miPropietario);
               }
            }

            @Override
            public void onFailure(Call<Propietarios> call, Throwable t) {

            }
        });
    }


public void actualizar(Propietarios propietario){
    SharedPreferences sp=context.getSharedPreferences("token",0);
    String accessToken=sp.getString("token","");
    Call<Propietarios> propietarioActualizado= ApiClient.getMyApiClient().actualizar(accessToken, propietario.getPropietarioId(),propietario.getDni(),propietario.getNombre(),propietario.getApellido(),propietario.getTelefono(),propietario.getMail(),propietario.getClave(),propietario.getBorrado());
    propietarioActualizado.enqueue(new Callback<Propietarios>() {
        @Override
        public void onResponse(Call<Propietarios> call, Response<Propietarios> response) {
            Log.d("salida","por actualizar");
            if(response.isSuccessful()){
                Toast.makeText(getApplication(),"Datos actualizados",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<Propietarios> call, Throwable t) {

        }
    });
    }
}
