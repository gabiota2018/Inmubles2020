package com.example.inmubles2020.ui.pagos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.inmubles2020.R;
import com.example.inmubles2020.ui.propiedades.detallePropiedaesViewModel;

public class detalle_pagos extends Fragment {
    private EditText etIdPago;
    private EditText etNumeroPago;
    private EditText etAlquilerPago;
    private EditText etFechaPago;
    private EditText etImportePago;

    private detallePagosViewModel vm;

    public detalle_pagos() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 vm=new detallePagosViewModel();
 vm.getIdPagos().observe(this, new Observer<String>() {
     @Override
     public void onChanged(String s) {
etIdPago.setText(s);
     }
 });
 vm.getNumeroPago().observe(this, new Observer<String>() {
     @Override
     public void onChanged(String s) {
         etNumeroPago.setText(s);
     }
 });
 vm.getAlquilerPago().observe(this, new Observer<String>() {
     @Override
     public void onChanged(String s) {
         etAlquilerPago.setText(s);
     }
 });
 vm.getFecha().observe(this, new Observer<String>() {
     @Override
     public void onChanged(String s) {
         etFechaPago.setText(s);
     }
 });
 vm.getImporte().observe(this, new Observer<String>() {
     @Override
     public void onChanged(String s) {
         etImportePago.setText(s);
     }
 });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detalle_pagos, container, false);
      etIdPago=view.findViewById(R.id.etIdPagos);
      etAlquilerPago=view.findViewById(R.id.etAlquilerPago);
      etFechaPago=view.findViewById(R.id.etFechaPago);
      etNumeroPago=view.findViewById(R.id.etNumeroPago);
      etImportePago=view.findViewById(R.id.etImportePago);

      String palabra=getArguments().getString("palabra");
      vm.obtenerDatosPagos(palabra);
      return  view;
    }
}
