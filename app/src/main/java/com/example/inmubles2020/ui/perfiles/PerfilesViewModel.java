package com.example.inmubles2020.ui.perfiles;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilesViewModel extends AndroidViewModel {
    private MutableLiveData<Propietario> propietarioMutableLiveData;
    private Context context;

    public PerfilesViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<Propietario> getPropietarioMutableLiveData(){
        if(propietarioMutableLiveData==null){
            propietarioMutableLiveData=new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
    }

    public void obtenerDatos(){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Propietario> propietarioCall= ApiClient.getMyApiClient().obtenerDatos(accessToken);

        propietarioCall.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    propietarioMutableLiveData.postValue(response.body());
               }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Log.d("salida",t.getMessage());
            }
        });
    }


public void actualizar(Propietario propietario){
    SharedPreferences sp=context.getSharedPreferences("token",0);
    String accessToken=sp.getString("token","");
    Call<Propietario> propietarioActualizado= ApiClient.getMyApiClient().actualizar(accessToken, propietario);

    propietarioActualizado.enqueue(new Callback<Propietario>() {
        @Override
        public void onResponse(Call<Propietario> call, Response<Propietario> response) {
            Log.d("salida","por actualizar");
            if(response.isSuccessful()){
                Toast.makeText(getApplication(),"Datos actualizados",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<Propietario> call, Throwable t) {
            Log.d("salida",t.getMessage());
        }
    });
    }
}
