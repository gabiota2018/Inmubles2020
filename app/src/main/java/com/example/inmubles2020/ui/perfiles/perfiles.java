package com.example.inmubles2020.ui.perfiles;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inmubles2020.R;
import com.example.inmubles2020.ui.perfiles.PerfilesViewModel;

import java.util.ArrayList;


public class perfiles extends Fragment {
    private EditText etDni,etApellido,etNombre,etTelefono,etMail,etPassword;
    private Button btnActualizar;
    private PerfilesViewModel vm;
    private Propietarios miPropietario;
   //propietarioId-dni-nombre-apellido-telefono-mail-password-borrado
    public perfiles() { }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm= ViewModelProviders.of(this).get(PerfilesViewModel.class);
        vm.getApellido().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etApellido.setText(s);

            }
        });
        vm.getDni().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etDni.setText(s);
            }
        });
        vm.getNombre().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etNombre.setText(s);
            }
        });
        vm.getTelefono().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etTelefono.setText(s);
            }
        });
        vm.getMail().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etMail.setText(s);
            }
        });
        vm.getPassword().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etPassword.setText(s);
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_perfiles, container, false);
        etDni=view.findViewById(R.id.etDni);
        etApellido=view.findViewById(R.id.etApellido);
        etNombre=view.findViewById(R.id.etNombre);
        etTelefono=view.findViewById(R.id.etTelefono);
        etMail=view.findViewById(R.id.etMail);
        etPassword=view.findViewById(R.id.etPassword);
        btnActualizar=view.findViewById(R.id.btnActualizarPerfil);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activar(view);
            }

        });
        // String palabra=getArguments().getString("palabra");
        vm.obtenerDatos();
        return view;
    }

       public void activar(View v){
           vm.obtenerDatos();
            if(btnActualizar.getText()=="EDITAR")
            {
                etDni.setEnabled(true);
                etApellido.setEnabled(true);
                etNombre.setEnabled(true);
                etTelefono.setEnabled(true);
                etMail.setEnabled(true);
                etPassword.setEnabled(true);
                btnActualizar.setText("GUARDAR");
            }
            else {
                etDni.setEnabled(false);
                etApellido.setEnabled(false);
                etNombre.setEnabled(false);
                etTelefono.setEnabled(false);
                etMail.setEnabled(false);
                etPassword.setEnabled(false);
                actualizar();
                btnActualizar.setText("EDITAR");
                vm.obtenerDatos();
            }
       }
        public void actualizar(){
                vm.getPropietarioMutableLiveData().observe(this, new Observer<Propietarios>() {
                    @Override
                    public void onChanged(Propietarios propietarios) {
                    miPropietario=propietarios;
                    vm.actualizar(miPropietario);
                    }
                });
        }
}
