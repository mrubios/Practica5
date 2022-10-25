package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.iesch.practica1.practica5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MENU");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        cargarBotones();


    }

    private void cargarBotones() {
        binding.rellayQuizzes.setOnClickListener(v -> {
            Intent intent = new Intent(this, Quizzes.class);
            startActivity(intent);
        });

        binding.rellayAmigos.setOnClickListener(v -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });

        binding.rellayCalculadora.setOnClickListener(v -> {
            Intent intent = new Intent(this, Calculadora.class);
            startActivity(intent);
        });
        binding.rellayBasket.setOnClickListener(v -> {
            Intent intent = new Intent(this, Basket.class);
            startActivity(intent);
        });
        binding.rellayPerrete.setOnClickListener(v -> {
            Intent intent = new Intent(this, EdadCanina.class);
            startActivity(intent);
        });
    }
}