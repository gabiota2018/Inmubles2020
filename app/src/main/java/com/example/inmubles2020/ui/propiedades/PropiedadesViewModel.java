package com.example.inmubles2020.ui.propiedades;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.inquilino.Inquilinos;
import com.example.inmubles2020.ui.perfiles.Propietarios;
import com.example.inmubles2020.ui.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class PropiedadesViewModel extends ViewModel {
    private MutableLiveData<List<String>> listaDeInmuebles;
    private Context context;

    public LiveData<List<String>> getListaDeInmuebles() {
        if(listaDeInmuebles==null){
            listaDeInmuebles=new MutableLiveData<>();
        }
        return listaDeInmuebles;
    }

    public void cargarDatos(){

        ArrayList<Inmuebles> todos=new ArrayList<Inmuebles>();
        ArrayList<String> listado=new ArrayList<String>();

        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Propietarios> propietarioCall= ApiClient.getMyApiClient().obtenerDatos(accessToken);

        listaDeInmuebles.setValue(listado);
    }
}
