package com.example.inmubles2020.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

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

        private MutableLiveData<String> etDireccionNu;
        private MutableLiveData<String> etAmbienteNu;
        private MutableLiveData<String> etTipoNu;
        private MutableLiveData<String> etUsoNu;
        private MutableLiveData<String> etPrecioNu;
        private MutableLiveData<Boolean> cbDisponibleNu;
        private Context context;

    public nuevaPropiedadViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> etDireccionNu() {
            if(etDireccionNu==null){
                etDireccionNu=new MutableLiveData<>();
            }
            return etDireccionNu;
        }
        public LiveData<String> etAmbienteNu() {
            if(etAmbienteNu==null){
                etAmbienteNu=new MutableLiveData<>();
            }
            return etAmbienteNu;
        }
        public LiveData<String> etTipoNu() {
            if(etTipoNu==null){
                etTipoNu=new MutableLiveData<>();
            }
            return etTipoNu;
        }
        public LiveData<String> etUsoNu() {
            if(etUsoNu==null){
                etUsoNu=new MutableLiveData<>();
            }
            return etUsoNu;
        }
        public LiveData<String> etPrecioNu() {
            if(etPrecioNu==null){
                etPrecioNu=new MutableLiveData<>();
            }
            return etPrecioNu;
        }
        public MutableLiveData<Boolean> cbDisponibleNu() {
            if(cbDisponibleNu==null){
                cbDisponibleNu=new MutableLiveData<>();
            }
            return cbDisponibleNu;
        }
public  void agregar(String direccion,String ambientes,String precio,String tipo,String uso, int disponer){
    Inmuebles miInmueble=new Inmuebles();
    miInmueble.setDireccion(direccion);
    miInmueble.setAmbientes(Integer.parseInt(ambientes));
    miInmueble.setTipo(tipo);
    miInmueble.setUso(uso);
    miInmueble.setPrecio(Double.parseDouble(precio));

    SharedPreferences sp=context.getSharedPreferences("token",0);
    String accessToken=sp.getString("token","");
    Call<Inmuebles> res = ApiClient.getMyApiClient().guardarInmueble(accessToken,miInmueble);

}

}
