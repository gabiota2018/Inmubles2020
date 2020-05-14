package com.example.inmubles2020.ui.inquilino;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmubles2020.R;

public class Detalle_inquilino extends Fragment {

    private  TextView idInq;
    private  TextView dniInq;
    private  TextView apellidoInq;
    private  TextView nombreInq;
    private  TextView telefonoInq;
    private  TextView direccionInq;

    private DetalleInquilinoViewModel vm;

    public Detalle_inquilino() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm=new DetalleInquilinoViewModel( );


     vm.getIdInq().observe(this, new Observer<String>() {
         @Override
         public void onChanged(String s) {
             idInq.setText(s);
         }
     });
     vm.getApellidoInq().observe(this, new Observer<String>() {
         @Override
         public void onChanged(String s) {
             apellidoInq.setText(s);
         }
     });
     vm.getNombreInq().observe(this, new Observer<String>() {
         @Override
         public void onChanged(String s) {
             nombreInq.setText(s);
         }
     });
     vm.getDniInq().observe(this, new Observer<String>() {
         @Override
         public void onChanged(String s) {
             dniInq.setText(s);
         }
     });
     vm.getTelefonoInq().observe(this, new Observer<String>() {
         @Override
         public void onChanged(String s) {
             telefonoInq.setText(s);
         }
     });
     vm.getDireccionInq().observe(this, new Observer<String>() {
         @Override
         public void onChanged(String s) {
             direccionInq.setText(s);
         }
     });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detalle_inquilino, container, false);
        idInq=view.findViewById(R.id.etIdA);
        dniInq=view.findViewById(R.id.etPrecioA);
        apellidoInq=view.findViewById(R.id.etFechaInicioA);
        nombreInq= view.findViewById(R.id.etFechaFinA);
        telefonoInq=view.findViewById(R.id.etTelefonoInq);
        direccionInq=view.findViewById(R.id.etDireccionInq);
        String palabra=getArguments().getString("palabra");
        vm.obtenerDatosInquilino(palabra);
        return view;
    }
}
