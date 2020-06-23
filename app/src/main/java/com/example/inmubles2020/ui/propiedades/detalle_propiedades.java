package com.example.inmubles2020.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inmubles2020.R;
import com.example.inmubles2020.ui.perfiles.PerfilesViewModel;
import com.example.inmubles2020.ui.perfiles.Propietario;


public class detalle_propiedades extends Fragment {
    private EditText etDireccionP;
    private EditText etAmbiente;
    private EditText etTipoP;
    private EditText etUsoP;
    private EditText etPrecioP;
    private CheckBox cbDisponibleP;
    private Button btnEditar;
    private Button btnEliminar;
    private detallePropiedaesViewModel vm;
    private Inmuebles miInmueble=null;

    public detalle_propiedades() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm= ViewModelProviders.of(this).get(detallePropiedaesViewModel.class);
        View view=inflater.inflate(R.layout.fragment_detalle_propiedades, container, false);
        etDireccionP=view.findViewById(R.id.etDireccionP);
        etAmbiente=view.findViewById(R.id.etAmbientesP);
        etPrecioP=view.findViewById(R.id.etPrecioP);
        etTipoP=view.findViewById(R.id.etTipoP);
        etUsoP=view.findViewById(R.id.etUsoP);
        cbDisponibleP=view.findViewById(R.id.cbDisponibleP);
        btnEditar=view.findViewById(R.id.btnGuardarP);
        btnEliminar=view.findViewById(R.id.btnGuardarP2);

        vm.getInmuebleMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Inmuebles>() {
            @Override
            public void onChanged(Inmuebles inmuebles) {
                etDireccionP.setText(inmuebles.getDireccion());
                etAmbiente.setText(inmuebles.getAmbientes()+"");
                etPrecioP.setText(inmuebles.getPrecio()+"");
                etTipoP.setText(inmuebles.getTipo());
                etUsoP.setText(inmuebles.getUso());
                if(inmuebles.getDisponible()==1)
                    cbDisponibleP.setChecked(true);
                else cbDisponibleP.setChecked(false);
                miInmueble=inmuebles;
            }
        });
       btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miInmueble.setDireccion(etDireccionP.getText().toString());
                miInmueble.setAmbientes(Integer.parseInt(etAmbiente.getText().toString()));
                miInmueble.setPrecio(Double.parseDouble(etPrecioP.getText().toString()));
                miInmueble.setTipo(etTipoP.getText().toString());
                miInmueble.setUso(etUsoP.getText().toString());
                if(cbDisponibleP.isChecked())miInmueble.setDisponible(1);
                else miInmueble.setDisponible(0);
               // Toast.makeText(getContext(),miInmueble.getInmuebleId()+"",Toast.LENGTH_LONG).show();
                vm.actualizar(miInmueble);
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            vm.borrar(miInmueble.getInmuebleId());
            }
        });
        final String palabra=getArguments().getString("palabra");
        vm.obtenerDatosInmuebles(palabra);
        return view;
    }

}
