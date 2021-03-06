package com.example.inmubles2020.ui.perfiles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inmubles2020.R;
import com.example.inmubles2020.ui.Usuario;


public class perfiles extends Fragment {
    private EditText etDni,etApellido,etNombre,etTelefono,etMail,etPassword;
    private Button btnActualizar;
    private PerfilesViewModel vm;
    private Propietario miPropietario=null;
   //propietarioId-dni-nombre-apellido-telefono-mail-password-borrado

    public perfiles() { }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        vm= ViewModelProviders.of(this).get(PerfilesViewModel.class);
        View view=inflater.inflate(R.layout.fragment_perfiles, container, false);
        etDni=view.findViewById(R.id.etDni);
        etApellido=view.findViewById(R.id.etApellido);
        etNombre=view.findViewById(R.id.etNombre);
        etTelefono=view.findViewById(R.id.etTelefono);
        etMail=view.findViewById(R.id.etMail);
        etPassword=view.findViewById(R.id.etPassword);
        btnActualizar=view.findViewById(R.id.btnActualizarPerfil);

        etDni.setEnabled(true);
        etApellido.setEnabled(true);
        etNombre.setEnabled(true);
        etTelefono.setEnabled(true);
        etMail.setEnabled(true);
        etPassword.setEnabled(true);

        vm.getPropietarioMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
               etDni.setText("DNI: "+propietario.getDni()+"");
               etApellido.setText("Apellido: "+propietario.getApellido());
               etNombre.setText("Nombre: "+propietario.getNombre());
               etTelefono.setText("Telefono: "+propietario.getTelefono());
               etMail.setText("Mail: "+propietario.getMail());
               etPassword.setText("Password: "+propietario.getClave());
               miPropietario=propietario;
          }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activar();
                actualizar();
            }
        });
        vm.obtenerDatos();
        return view;
    }

       public void activar(){
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
                btnActualizar.setText("EDITAR");
            }
       }

        public void actualizar(){
            //propietarioId-dni-nombre-apellido-telefono-mail-password-borrado
                miPropietario.setDni(Integer.parseInt(etDni.getText().toString()));
                miPropietario.setApellido(etApellido.getText().toString());
                miPropietario.setNombre(etNombre.getText().toString());
                miPropietario.setTelefono(etTelefono.getText().toString());
                miPropietario.setMail(etMail.getText().toString());
                miPropietario.setClave(etPassword.getText().toString());
                vm.actualizar(miPropietario);
        }
}
