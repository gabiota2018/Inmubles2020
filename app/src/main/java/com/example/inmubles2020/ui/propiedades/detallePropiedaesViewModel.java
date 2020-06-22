package com.example.inmubles2020.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmubles2020.ui.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detallePropiedaesViewModel extends AndroidViewModel {

    private MutableLiveData<String> etDireccionP;
    private MutableLiveData<String> etAmbienteP;
    private MutableLiveData<String> etTipoP;
    private MutableLiveData<String> etUsoP;
    private MutableLiveData<String> etPrecioP;
    private MutableLiveData<Boolean> cbDisponibleP;
    private Context context;

    public detallePropiedaesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> etDireccionP() {
        if(etDireccionP==null){
            etDireccionP=new MutableLiveData<>();
        }
        return etDireccionP;
    }
    public LiveData<String> etAmbienteP() {
        if(etAmbienteP==null){
            etAmbienteP=new MutableLiveData<>();
        }
        return etAmbienteP;
    }
    public LiveData<String> etTipoP() {
        if(etTipoP==null){
            etTipoP=new MutableLiveData<>();
        }
        return etTipoP;
    }
    public LiveData<String> etUsoP() {
        if(etUsoP==null){
            etUsoP=new MutableLiveData<>();
        }
        return etUsoP;
    }
    public LiveData<String> etPrecioP() {
        if(etPrecioP==null){
            etPrecioP=new MutableLiveData<>();
        }
        return etPrecioP;
    }
    public MutableLiveData<Boolean> cbDisponibleP() {
        if(cbDisponibleP==null){
            cbDisponibleP=new MutableLiveData<>();
        }
        return cbDisponibleP;
    }


    public void obtenerDatosInmuebles(String palabra){
        //Inmuebles miInmuebles=new Inmuebles();
        String[] partes = palabra.split("-");
        //queda el Id del inmueble en part1
        Integer part1 =Integer. parseInt(partes[0]);
        //miInmuebles=miInmuebles.obtenerPorIdInmueble(part1);
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> inmuebleCall = ApiClient.getMyApiClient().obtenerDatosInmueble(accessToken,part1);
        inmuebleCall.enqueue(new Callback<Inmuebles>() {
            @Override
            public void onResponse(Call<Inmuebles> call, Response<Inmuebles> response) {
                if(response.isSuccessful()){
                    Inmuebles miInmuebles=response.body();
                    etDireccionP.setValue(miInmuebles.getDireccion());
                    etAmbienteP.setValue("Cantidad de ambientes: "+miInmuebles.getAmbientes()+"");
                    etTipoP.setValue("Tipo de inmueble: "+miInmuebles.getTipo());
                    etUsoP.setValue("Uso permitido: "+miInmuebles.getUso());
                    etPrecioP.setValue("Cuota mensual $: "+miInmuebles.getPrecio()+"");
                    if(miInmuebles.getDisponible()==1)
                        cbDisponibleP.setValue(true);
                    else
                        cbDisponibleP.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<Inmuebles> call, Throwable t) {

            }
        });


    }
    public  void actualizar(String direccion,String ambientes,String precio,String tipo,String uso, int disponer,int id){
       Inmuebles miInmueble=new Inmuebles();
        miInmueble.setIdInmueble(id);
        miInmueble.setDireccion(direccion);
        miInmueble.setAmbientes(Integer.parseInt(ambientes));
        miInmueble.setTipo(tipo);
        miInmueble.setUso(uso);
        miInmueble.setPrecio(Double.parseDouble(precio));

        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> nuevo = ApiClient.getMyApiClient().actualizarInmueble(accessToken,id,miInmueble);
    }
    public  void borrar(int id){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> inmueblesCall = ApiClient.getMyApiClient().bajaInmueble(accessToken,id);
    }
}
