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
    private Inmuebles miInmueble=null;

    public nueva_propiedad() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm=ViewModelProviders.of(this).get(nuevaPropiedadViewModel.class);
        View view=inflater.inflate(R.layout.fragment_nueva_propiedad, container, false);
        etDireccionNu=view.findViewById(R.id.etDireccionNu);
        etAmbienteNu=view.findViewById(R.id.etAmbientesNu);
        etPrecioNu=view.findViewById(R.id.etPrecioNu);
        etTipoNu=view.findViewById(R.id.etTipoNu);
        etUsoNu=view.findViewById(R.id.etUsoNu);
        cbDisponibleNu=view.findViewById(R.id.cbDisponibleNu);
        btnAgregarNu=view.findViewById(R.id.btnAgregarNu);

        vm.getInmuebleMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Inmuebles>() {
            @Override
            public void onChanged(Inmuebles inmuebles) {
                etDireccionNu.setText(inmuebles.getDireccion());
                etAmbienteNu.setText(inmuebles.getAmbientes()+"");
                etPrecioNu.setText(inmuebles.getPrecio()+"");
                etTipoNu.setText(inmuebles.getTipo());
                etUsoNu.setText(inmuebles.getUso());
                if(inmuebles.getDisponible()==1)
                    cbDisponibleNu.setChecked(true);
                else cbDisponibleNu.setChecked(false);
                miInmueble=inmuebles;
            }
        });
        btnAgregarNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miInmueble.setDireccion(etDireccionNu.getText().toString());
                miInmueble.setAmbientes(Integer.parseInt(etAmbienteNu.getText().toString()));
                miInmueble.setPrecio(Double.parseDouble(etPrecioNu.getText().toString()));
                miInmueble.setTipo(etTipoNu.getText().toString());
                miInmueble.setUso(etUsoNu.getText().toString());
                if(cbDisponibleNu.isChecked())miInmueble.setDisponible(1);
                else miInmueble.setDisponible(0);
                vm.agregar(miInmueble);
                   }
        });
        return view;
    }

}

