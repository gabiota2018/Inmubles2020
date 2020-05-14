package com.example.inmubles2020;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.inmubles2020.ui.perfiles.Propietarios;


public class Logueo extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etPassword;
    private Button btnEnviar;
    private TextView tvMensaje;
    private Propietarios miPropietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
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
               logueo();
           }
       });
}
    public  void logueo(){
        miPropietario=new Propietarios();
        String correo=etUsuario.getText().toString();
        String clave=etPassword.getText().toString();
        boolean rta=miPropietario.logueo(correo,clave);
        if(rta)
        {
            miPropietario=miPropietario.devolverPropietario(correo);
            Intent i=new Intent(Logueo.this, MainActivity.class);
            i.putExtra("usuario",miPropietario.getMail());
            Logueo.this.startActivity(i);
        }
        else
            tvMensaje.setText("Datos incorrectos");
    }
}
