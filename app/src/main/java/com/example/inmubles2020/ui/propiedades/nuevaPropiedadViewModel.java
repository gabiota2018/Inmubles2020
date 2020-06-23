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
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class nuevaPropiedadViewModel  extends AndroidViewModel {
    private  MutableLiveData<Inmuebles> inmuebleMutableLiveData;
    private Context context;

    public nuevaPropiedadViewModel(@NonNull Application application) {
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
    public  void agregar(Inmuebles miInmueble){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> inmuebleNuevo = ApiClient.getMyApiClient().guardarInmueble(accessToken,miInmueble);

        inmuebleNuevo.enqueue(new Callback<Inmuebles>() {
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
