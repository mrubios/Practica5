package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.iesch.practica1.practica5.databinding.ActivityDetailLoginBinding;

public class DetailLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);
        setTitle("BIENVENIDA");
        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email");
        String passwd = extras.getString("passwd");

        ActivityDetailLoginBinding building = ActivityDetailLoginBinding.inflate(getLayoutInflater());
        setContentView(building.getRoot());
        getSupportActionBar().setTitle(email);


        building.txtBienvenida.setText("Hola, " + email);


    }
}