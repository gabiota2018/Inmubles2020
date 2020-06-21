package com.example.inmubles2020.ui.propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmubles2020.R;
import com.example.inmubles2020.ui.perfiles.PerfilesViewModel;

public class nueva_propiedad extends Fragment {
    private EditText etDireccionNu;
    private EditText etAmbienteNu;
    private EditText etTipoNu;
    private EditText etUsoNu;
    private EditText etPrecioNu;
    private CheckBox cbDisponibleNu;
    private Button btnAgregarNu;
    private nuevaPropiedadViewModel vm;

    public nueva_propiedad() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       vm=ViewModelProviders.of(this).get(nuevaPropiedadViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_nueva_propiedad, container, false);
        etDireccionNu=view.findViewById(R.id.etDireccionNu);
        etAmbienteNu=view.findViewById(R.id.etAmbientesNu);
        etPrecioNu=view.findViewById(R.id.etPrecioNu);
        etTipoNu=view.findViewById(R.id.etTipoNu);
        etUsoNu=view.findViewById(R.id.etUsoNu);
        cbDisponibleNu=view.findViewById(R.id.cbDisponibleNu);
        btnAgregarNu=view.findViewById(R.id.btnAgregarNu);

        btnAgregarNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int disponer=0;
                if(cbDisponibleNu.isChecked())disponer=1;
                vm.agregar(etDireccionNu.getText().toString(),etAmbienteNu.getText().toString(),etPrecioNu.getText().toString(),etTipoNu.getText().toString(),etUsoNu.getText().toString(),disponer);
            }
        });
        return view;
    }

}

