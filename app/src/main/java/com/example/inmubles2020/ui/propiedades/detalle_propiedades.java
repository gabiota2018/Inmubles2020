package com.example.inmubles2020.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inmubles2020.R;


public class detalle_propiedades extends Fragment {
    private EditText etDireccionP;
    private EditText etAmbiente;
    private EditText etTipoP;
    private EditText etUsoP;
    private EditText etPrecioP;
    private CheckBox cbDisponibleP;
    private Button btnGuardarP;
    private detallePropiedaesViewModel vm;

    public detalle_propiedades() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       vm=new detallePropiedaesViewModel();
       vm.etDireccionP().observe(this, new Observer<String>() {
           @Override
           public void onChanged(String s) {
               etDireccionP.setText(s);
           }
       });
       vm.etAmbienteP().observe(this, new Observer<String>() {
           @Override
           public void onChanged(String s) {
               etAmbiente.setText(s);
           }
       });
       vm.etTipoP().observe(this, new Observer<String>() {
           @Override
           public void onChanged(String s) {
               etTipoP.setText(s);
           }
       });
       vm.etUsoP().observe(this, new Observer<String>() {
           @Override
           public void onChanged(String s) {
               etUsoP.setText(s);
           }
       });
       vm.etPrecioP().observe(this, new Observer<String>() {
           @Override
           public void onChanged(String s) {
               etPrecioP.setText(s);
           }
       });
       vm.cbDisponibleP().observe(this, new Observer<Boolean>() {
           @Override
           public void onChanged(Boolean aBoolean) {
               cbDisponibleP.setChecked(aBoolean);
           }
       });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detalle_propiedades, container, false);
        etDireccionP=view.findViewById(R.id.etDireccionP);
        etAmbiente=view.findViewById(R.id.etAmbientesP);
        etPrecioP=view.findViewById(R.id.etPrecioP);
        etTipoP=view.findViewById(R.id.etTipoP);
        etUsoP=view.findViewById(R.id.etUsoP);
        cbDisponibleP=view.findViewById(R.id.cbDisponibleP);
       btnGuardarP=view.findViewById(R.id.btnGuardarP);
        String palabra=getArguments().getString("palabra");
        vm.obtenerDatosInmuebles(palabra);
        return view;
    }
}
