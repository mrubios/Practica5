package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.iesch.practica1.practica5.databinding.ActivityBasketBinding;

public class Basket extends AppCompatActivity {
    private ActivityBasketBinding binding;
    private int localScore=0;
    private int visitorScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupButtons();
    }

    private void setupButtons() {
        binding.restarLocal.setOnClickListener(v->{
            if (localScore>0)
            {
                localScore--;
                binding.marcadorLocal.setText(String.valueOf(localScore));
            }
        });

        binding.restarVisitante.setOnClickListener(v->{
            if (visitorScore>0)
            {
                visitorScore--;
                binding.marcadorVisitante.setText(String.valueOf(visitorScore));
            }
        });

        binding.sumarUnoLocal.setOnClickListener(v->{
            addPoints(1, true);
        });

        binding.sumarDosLocal.setOnClickListener(v->{
            addPoints(2, true);
        });

        binding.sumarUnoVisitante.setOnClickListener(v->{
            addPoints(1, false);
        });

        binding.sumarDosVisitante.setOnClickListener(v->{
            addPoints(2, false);
        });
        binding.btnRestart.setOnClickListener(v->{
            resetScores();
        });
        binding.btnResultado.setOnClickListener(v->{
            finalizarPartido();
        });

    }

    private void finalizarPartido() {
        Intent intent = new Intent(this, ResultadoBasket.class);
        intent.putExtra("localScore", localScore);
        intent.putExtra("visitorScore", visitorScore);
        startActivity(intent);}

    private void resetScores(){
        localScore = 0;
        visitorScore= 0;
        binding.marcadorVisitante.setText(String.valueOf(0));
        binding.marcadorLocal.setText(String.valueOf(0));
    }

    private void addPoints(int points, boolean isLocal) {
        if(isLocal){
            localScore+=points;
            binding.marcadorLocal.setText(String.valueOf(localScore));
        }else{
            visitorScore+=points;
            binding.marcadorVisitante.setText(String.valueOf(visitorScore));
        }
    }
}