package com.example.inmubles2020.ui.contratos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inmubles2020.R;


public class detalle_contratos extends Fragment {
    private EditText etIdA;
    private EditText etPrecioA;
    private EditText etFechaInicioA;
    private EditText etFechaFinA;

    private  detalleContratosViewModel vm;
    public detalle_contratos() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm=new detalleContratosViewModel();
        vm.etIdA().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etIdA.setText(s);
            }
        });

        vm.etPrecioA().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etPrecioA.setText(s);
            }
        });

        vm.etFechaInicioA().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etFechaInicioA.setText(s);
            }
        });
        vm.etFechaFinA().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etFechaFinA.setText(s);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view= inflater.inflate(R.layout.fragment_detalle_contratos, container, false);
        etIdA=view.findViewById(R.id.etIdA);
        etPrecioA=view.findViewById(R.id.etPrecioA);
        etFechaInicioA=view.findViewById(R.id.etFechaInicioA);
        etFechaFinA=view.findViewById(R.id.etFechaFinA);

        String palabra=getArguments().getString("palabra");
        vm.obtenerDatosAlquileres(palabra);//segun el id del inmueble...
        return  view;
    }
}
