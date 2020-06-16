package com.example.inmubles2020;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmubles2020.ui.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogueoViewModel extends AndroidViewModel {
    private MutableLiveData<String> etUsuario;
    private MutableLiveData<String> etPassword;
    private MutableLiveData<Integer> tvMensajeLogueo;
    private MutableLiveData<String> token;
    private Context context;



    public LogueoViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public LiveData<Integer> getTvMensajeLogueo(){
        if(tvMensajeLogueo==null){
            tvMensajeLogueo=new MutableLiveData<>();
        }
        return tvMensajeLogueo;
    }
    public LiveData<String> getToken(){
        if(token==null){
            token=new MutableLiveData<>();
        }
        return token;
    }
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

    public  void logueo(String usuario,String clave) {
        boolean rta = false;
        Call<String> dato = ApiClient.getMyApiClient().login(usuario, clave);
        dato.enqueue((new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                    token.postValue(response.body());
                    SharedPreferences sp = context.getSharedPreferences("token", 0);
                    SharedPreferences.Editor editor = sp.edit();
                    String t = "Bearer" + response.body();
                    editor.putString("token", t);
                    editor.commit();
                    Log.d("salida ultimo token", t);
                    tvMensajeLogueo.postValue(8);
                }
                else tvMensajeLogueo.postValue(1);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                tvMensajeLogueo.postValue(0);
                Log.d("salida Error",t.getMessage());
                Log.d("salida Error",call.request().body().toString());
                t.printStackTrace();
            }
        }));

    }
}

