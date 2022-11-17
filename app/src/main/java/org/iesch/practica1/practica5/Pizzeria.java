package org.iesch.practica1.practica5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.iesch.practica1.practica5.PizzaApi.PizzaapiService;
import org.iesch.practica1.practica5.modelo.Pizza;
import org.iesch.practica1.practica5.modelo.PizzaRespuesta;
import org.iesch.practica1.practica5.pizzaAdapter.ListaPizzaAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pizzeria extends AppCompatActivity {

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaPizzaAdapter listaPizzaAdapter;
    private int offset;
    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria);

        setTitle("Pizzería");

        recyclerView = findViewById(R.id.recyclerView);
        listaPizzaAdapter = new ListaPizzaAdapter(this);
        recyclerView.setAdapter(listaPizzaAdapter);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                if(aptoParaCargar){
                    if((visibleItemCount + pastVisibleItems) >= totalItemCount){
                        Log.i("Pizza", "Llegamos al final");
                        aptoParaCargar=false;
                        offset+=20;
                        obtenerDatos(offset);
                    }
                }
            }
        });



        retrofit = new Retrofit.Builder().baseUrl("https://private-anon-9482475d2f-codingpizza.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        aptoParaCargar=true;
        offset = 0;
        obtenerDatos(offset);
    }


    public void obtenerDatos(int offset){
        PizzaapiService service = retrofit.create(PizzaapiService.class);
        Call<PizzaRespuesta> pizzaRespuestaCall = service.obtenerListaPiza(20, offset);

        pizzaRespuestaCall.enqueue(new Callback<PizzaRespuesta>() {
            @Override
            public void onResponse(Call<PizzaRespuesta> call, Response<PizzaRespuesta> response) {
                aptoParaCargar = true;
                if(response.isSuccessful()){
                    PizzaRespuesta pizzaRespuesta = response.body();
                    ArrayList<Pizza> listaPizza = pizzaRespuesta.getResults();
                    listaPizzaAdapter.adicionarPizza(listaPizza);
                }
                else{
                    Log.i("PIZZA", "onResponse: " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<PizzaRespuesta> call, Throwable t) {
                aptoParaCargar=true;
                Log.i("PIZZA", "onFailure: " + t.getMessage());
            }
        });
    }
}