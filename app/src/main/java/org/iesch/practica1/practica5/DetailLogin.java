package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


public class DetailLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();

        Obj_editor.putString("email","");
        Obj_editor.putString("pass","");
        Obj_editor.commit();

        Intent i = new Intent(DetailLogin.this, Login.class);
        startActivity(i);

    }
}