package org.iesch.practica1.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Musica extends AppCompatActivity {

    private ListView lv;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        getSupportActionBar().hide();
        lv=findViewById(R.id.lv);
        adaptador = new Adaptador(obtenerLista(), this);
        lv.setAdapter(adaptador);
    }

    private ArrayList<Album> obtenerLista() {
        ArrayList<Album> lista = new ArrayList<>();
        lista.add(new Album(R.drawable.oscuro_extasis, "OSCURO EXTASIS", "WOS", "2021"));
        lista.add(new Album(R.drawable.puntos_suspensivos, "TRES PUNTOS SUSPENSIVOS", "WOS", "2020"));
        lista.add(new Album(R.drawable.portales, "PORTALES", "Tiago PZK", "2021"));
        lista.add(new Album(R.drawable.la_melodia, "LA MELODÍA", "Dani Ribba", "2022"));
        lista.add(new Album(R.drawable.unveranosinti, "UN VERANO SIN TI", "Bad Bunny", "2022"));
        lista.add(new Album(R.drawable.inmortales, "INMORTALES", "Funzo & Baby Loud", "2022"));
        lista.add(new Album(R.drawable.passenger, "ALL THE LITTLE THINGS", "Passenger", "2012"));
        lista.add(new Album(R.drawable.montero, "MONTERO", "Lil Nas X", "2021"));
        lista.add(new Album(R.drawable.isla_lp, "LA ISLA LP", "Rels B", "2020"));
        lista.add(new Album(R.drawable.el_madrileno, "EL MADRILEÑO", "C. Tangana", "2021"));
        return lista;
    }
}