package com.example.inmubles2020;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.inmubles2020.ui.perfiles.Propietarios;


public class Logueo extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etPassword;
    private Button btnEnviar;
    private TextView tvMensaje;
    private LogueoViewModel vm;
   //private Propietarios miPropietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
        vm=new LogueoViewModel();
        iniciarVista();
    }

private void iniciarVista(){
        etUsuario=findViewById(R.id.etMailLogueo);
        etPassword=findViewById(R.id.etPasswordLogueo);
        tvMensaje=findViewById(R.id.tvMensajeLogueo);
        btnEnviar=findViewById(R.id.btnEnviarLogueo);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Boolean rta=vm.logueo(etUsuario.getText().toString(),etPassword.getText().toString());
               if(rta)
               {
                   Intent i=new Intent(Logueo.this, MainActivity.class);
                   Logueo.this.startActivity(i);
               }
           }
       });
}

}
