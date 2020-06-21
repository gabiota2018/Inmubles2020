package com.example.inmubles2020.ui.propiedades;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.inquilino.Inquilinos;
import com.example.inmubles2020.ui.perfiles.Propietarios;
import com.example.inmubles2020.ui.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detallePropiedaesViewModel extends ViewModel {

    private MutableLiveData<String> etDireccionP;
    private MutableLiveData<String> etAmbienteP;
    private MutableLiveData<String> etTipoP;
    private MutableLiveData<String> etUsoP;
    private MutableLiveData<String> etPrecioP;
    private MutableLiveData<Boolean> cbDisponibleP;
    private Context context;

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
    public  void actualizar(String direccion,int ambientes,double precio,String tipo,String uso, int disponer,String palabra){
        String[] partes = palabra.split("-");
        //queda el Id del inmueble en part1
        Integer part1 =Integer. parseInt(partes[0]);
        Inmuebles miInmueble=new Inmuebles();
        miInmueble.setIdInmueble(part1);
        miInmueble.setDireccion(direccion);
        miInmueble.setAmbientes(ambientes);
        miInmueble.setTipo(tipo);
        miInmueble.setUso(uso);
        miInmueble.setPrecio(precio);

        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Inmuebles> res = ApiClient.getMyApiClient().actualizarInmueble(accessToken,part1,miInmueble);
    }
}
