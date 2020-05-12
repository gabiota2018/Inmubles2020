package com.example.inmubles2020.ui.pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.propiedades.Inmuebles;

public class detallePagosViewModel extends ViewModel {
    private MutableLiveData<String> idPagos;
    private MutableLiveData<String> numeroPago;
    private MutableLiveData<String> alquilerPago;
    private MutableLiveData<String> fecha;
    private MutableLiveData<String> importe;

    public LiveData<String> getIdPagos() {
        if(idPagos==null){
            idPagos=new MutableLiveData<>();
        }
        return idPagos;
    }
    public LiveData<String> getNumeroPago() {
        if(numeroPago==null){
            numeroPago=new MutableLiveData<>();
        }
        return numeroPago;
    }
    public LiveData<String> getAlquilerPago() {
        if(alquilerPago==null){
            alquilerPago =new MutableLiveData<>();
        }
        return alquilerPago;
    }
    public LiveData<String> getFecha() {
        if(fecha==null){
           fecha=new MutableLiveData<>();
        }
        return fecha;
    }
    public LiveData<String> getImporte() {
        if(importe==null){
           importe=new MutableLiveData<>();
        }
        return importe;
    }
    public void obtenerDatosPagos(String palabra){
        Pago miPago=new Pago();
        String[] partes = palabra.split("-");
        Integer part1 =Integer. parseInt(partes[0]);
        miPago=miPago.obtenerPorIdPago(part1);
        idPagos.setValue(miPago.getIdPago()+"");
        numeroPago.setValue(miPago.getNroPago()+"");
        alquilerPago.setValue(miPago.getIdAlquiler()+"");//traeer el domicilio y el inquilino
        fecha.setValue(miPago.getFecha());
        importe.setValue(miPago.getImporte()+"");

    }
}
