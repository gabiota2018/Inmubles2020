package com.example.inmubles2020.ui.pagos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmubles2020.R;
import com.example.inmubles2020.ui.inquilino.InquilinoViewModel;

import java.util.List;

public class detalle_pagos extends Fragment {

    private ListView lv;
    private detallePagosViewModel vm;
    private TextView tvMensaje;

    public detalle_pagos() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm=new detallePagosViewModel();
        vm.getListaDePagos().observe(this,new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,strings);
                lv.setAdapter(adapter);
            }
        });
        vm.getTvMensaje().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvMensaje.setText(s);
            }
        });
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detalle_pagos, container, false);
        String palabra=getArguments().getString("palabra");
        vm.cargarDatos(palabra);//lleva el id del inmueble alquilado
        tvMensaje=view.findViewById(R.id.etDireccionPagos);
        lv=view.findViewById(R.id.listaPagos);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView)view;
                Bundle bundle=new Bundle();
                bundle.putString("palabra",tv.getText().toString());
                Navigation.findNavController(view).navigate(R.id.detalle_pagos, bundle);
            }
        });
        return view;
    }
}
