package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.iesch.practica1.practica5.databinding.ActivityMainLoginBinding;

public class Login extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setTitle("LOGIN");


        ActivityMainLoginBinding building = ActivityMainLoginBinding.inflate(getLayoutInflater());
        setContentView(building.getRoot());
        getSupportActionBar().setTitle("Iniciar Sesión");

        txtEmail =building.txtEmail;
        txtPasswd = building.txtPasswd;

        Button btn = building.btnEnter;

            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

            if (preferencias.getString("email","") != ""){
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }

            txtEmail.setText(preferencias.getString("email",""));
            txtPasswd.setText(preferencias.getString("pass",""));

            btn.setOnClickListener(w -> {
                if(!String.valueOf(txtEmail.getText()).isEmpty() && !String.valueOf(txtPasswd.getText()).isEmpty()) {
                    guardar();
                    Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Debes introducir tus datos", Toast.LENGTH_SHORT).show();
                }
            });

    }
    private void guardar() {
        // En este método he de crear el objeto nuevamente
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // Editor esla clase que me sirve para modificar este archivo
        SharedPreferences.Editor Obj_editor = preferences.edit();

        Obj_editor.putString("email", txtEmail.getText().toString());
        Obj_editor.putString("pass", txtPasswd.getText().toString());
        //Commit confirma que lo que acabamoos de recuperar arriba lo queremos GUARDAR.
        // Sin commit no guarda nada en SharedPreferences
        Obj_editor.commit();

        Intent i = new Intent(Login.this, MainActivity.class);
        startActivity(i);

    }
}