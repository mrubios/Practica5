package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import org.iesch.practica1.practica5.databinding.ActivityResultadoBinding;


public class Resultado extends AppCompatActivity {
    ActivityResultadoBinding binding;
    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        numero = extras.getInt("contador");
        Boolean correcto = extras.getBoolean("correcto");

        if(correcto == true){
            binding.resultado.setText(R.string.acierto);
        }else{
            binding.resultado.setText(R.string.fallo);
        }

        if(numero == 3){
            binding.finish.setText(R.string.finalisimo);

            binding.btnNext.setText(R.string.start);
        }

        pulsarBoton();
    }

    private void pulsarBoton() {
        Intent activity = new Intent(this, Quizzes.class);

        binding.btnNext.setOnClickListener(v->{
            if (numero != 3){
                activity.putExtra("contador", numero);
            }else{
                activity.putExtra("contador", 0);
            }
            startActivity(activity);
        });

    }
}