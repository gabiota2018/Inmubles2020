package com.example.inmubles2020.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.inquilino.Inquilinos;
import com.example.inmubles2020.ui.perfiles.Propietarios;
import com.example.inmubles2020.ui.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropiedadesViewModel extends AndroidViewModel {
    private MutableLiveData<List<String>> listaDeInmuebles;
    private Context context;

    public PropiedadesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<String>> getListaDeInmuebles() {
        if(listaDeInmuebles==null){
            listaDeInmuebles=new MutableLiveData<>();
        }
        return listaDeInmuebles;
    }

    public void cargarDatos(){

        ArrayList<Inmuebles> todos=new ArrayList<Inmuebles>();
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<List<Inmuebles>> listaInmueblesCall = ApiClient.getMyApiClient().listarInmuebles(accessToken);
        listaInmueblesCall.enqueue(new Callback<List<Inmuebles>>() {
            @Override
            public void onResponse(Call<List<Inmuebles>> call, Response<List<Inmuebles>> response) {
                if(response.isSuccessful()){
                    List<Inmuebles> todos= response.body();
                    ArrayList<String> listado=new ArrayList<String>();
                    String cadena="";
                    for (Inmuebles s: todos) {
                        cadena="";
                        cadena=s.getIdInmueble()+"-"+s.getDireccion()+" ";
                            listado.add(cadena);
                       }
                    listaDeInmuebles.postValue(listado);

                } else {
                    Toast.makeText(context, "Error.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Inmuebles>> call, Throwable t) {

            }
        });
    }

}
