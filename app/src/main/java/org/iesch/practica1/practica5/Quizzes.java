package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


import org.iesch.practica1.practica5.databinding.ActivityQuizzesBinding;

import java.util.ArrayList;
import java.util.List;

public class Quizzes extends AppCompatActivity {

    List<Preguntas> listaPregunta = new ArrayList<>();
    ActivityQuizzesBinding binding;
    public int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizzesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        try {
            Bundle extras = getIntent().getExtras();
            contador = extras.getInt("contador");
        }catch (Exception e){
            contador = 0;
        }

        agregarPreguntas();

        cargarPregunta();

        pulsarBoton();
    }

    private void pulsarBoton() {
        Button btn = binding.btnSend;

        Intent activity = new Intent(this, Resultado.class);
        Preguntas pregunta = listaPregunta.get(contador);

        binding.btnSend.setOnClickListener(v->{
            if(binding.respuesta1.isChecked()){
                if(binding.respuesta1.getText().equals(pregunta.respuestaCorrecta)){
                    activity.putExtra("correcto", true);
                    activity.putExtra("contador", pregunta.numero);
                    startActivity(activity);
                }
                else{
                    activity.putExtra("correcto", false);
                    activity.putExtra("contador", pregunta.numero);
                    startActivity(activity);
                }
            }else if (binding.respuesta2.isChecked()){
                if(binding.respuesta2.getText().equals(pregunta.respuestaCorrecta)){
                    activity.putExtra("correcto", true);
                    activity.putExtra("contador", pregunta.numero);
                    startActivity(activity);
                }
                else{
                    activity.putExtra("correcto", false);
                    activity.putExtra("contador", pregunta.numero);
                    startActivity(activity);
                }
            }else{
                Toast.makeText(this, R.string.selecciona, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void cargarPregunta() {
        Preguntas pregunta = listaPregunta.get(contador);

        binding.titulo.setText(pregunta.numero + " / 3");
        binding.enunciado.setText(getString(R.string.choose_the_correct));
        binding.problema.setText(pregunta.pregunta);
        ordenPreguntas(pregunta);

    }

    private void ordenPreguntas(Preguntas pregunta) {
        int random = (int) (Math.random()*10+1);
        if(random % 2 != 0)
        {
            binding.respuesta1.setText(pregunta.respuestaCorrecta);
            binding.respuesta2.setText(pregunta.respuestaIncorrecta);
        }
        else{
            binding.respuesta2.setText(pregunta.respuestaCorrecta);
            binding.respuesta1.setText(pregunta.respuestaIncorrecta);
        }
    }

    private void agregarPreguntas() {
        Preguntas pregunta = new Preguntas(1, getString(R.string.pregunta1), getString(R.string.respuestaCorrecta1), getString(R.string.respuestaIncorrecta1));
        listaPregunta.add(pregunta);
        pregunta = new Preguntas(2, getString(R.string.pregunta2), "D", "H");
        listaPregunta.add(pregunta);
        pregunta = new Preguntas(3, getString(R.string.pregunta3), "Isaac Newton", "Jeff Bezos");
        listaPregunta.add(pregunta);
    }
}