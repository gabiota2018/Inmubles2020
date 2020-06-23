package com.example.inmubles2020.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmubles2020.ui.request.ApiClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detallePropiedaesViewModel extends AndroidViewModel {
    private  MutableLiveData<Inmuebles> inmuebleMutableLiveData;
    private Context context;


    public detallePropiedaesViewModel(@NonNull Application application) {

        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Inmuebles> getInmuebleMutableLiveData()
    {
        if(inmuebleMutableLiveData == null)
        {
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }



    public void obtenerDatosInmuebles(String palabra){
        String[] partes = palabra.split("-");
        Integer id =Integer. parseInt(partes[0]);

        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> inmuebleCall = ApiClient.getMyApiClient().obtenerDatosInmueble(accessToken,id);

        inmuebleCall.enqueue(new Callback<Inmuebles>() {
            @Override
            public void onResponse(Call<Inmuebles> call, Response<Inmuebles> response) {
                if(response.isSuccessful()){
                    inmuebleMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Inmuebles> call, Throwable t) {
                Log.d("salida",t.getMessage());
            }
        });


    }
    public  void actualizar(Inmuebles miInmueble){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> inmuebleActualizado = ApiClient.getMyApiClient().actualizarInmueble(accessToken,miInmueble.getInmuebleId(),miInmueble);

        inmuebleActualizado.enqueue(new Callback<Inmuebles>() {
            @Override
            public void onResponse(Call<Inmuebles> call, Response<Inmuebles> response) {
                Log.d("salida","por actualizar");
                if(response.isSuccessful()){
                    Toast.makeText(getApplication(),"Datos actualizados",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmuebles> call, Throwable t) {
                Log.d("salida",t.getMessage());
            }
        });
    }
    public  void borrar(int id){

        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> inmuebleBorrado = ApiClient.getMyApiClient().bajaInmueble(accessToken,id);

        inmuebleBorrado.enqueue(new Callback<Inmuebles>() {
            @Override
            public void onResponse(Call<Inmuebles> call, Response<Inmuebles> response) {
                Log.d("salida","por actualizar");
                if(response.isSuccessful()){
                    Toast.makeText(getApplication(),"Datos actualizados",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmuebles> call, Throwable t) {
                Log.d("salida",t.getMessage());
            }
        });
    }
}
