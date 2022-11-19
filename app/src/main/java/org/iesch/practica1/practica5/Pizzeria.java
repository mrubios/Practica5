package org.iesch.practica1.practica5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.iesch.practica1.practica5.PizzaApi.PizzaapiService;
import org.iesch.practica1.practica5.modelo.Pizza;
import org.iesch.practica1.practica5.pizzaAdapter.ListaPizzaAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pizzeria extends AppCompatActivity {

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaPizzaAdapter listaPizzaAdapter;


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


                        Log.i("Pizza", "Llegamos al final");
                        obtenerDatos();


            }
        });



        retrofit = new Retrofit.Builder().baseUrl("https://private-anon-2da0e872d7-codingpizza.apiary-mock.com/v2/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        obtenerDatos();
    }


    public void obtenerDatos(){
        PizzaapiService service = retrofit.create(PizzaapiService.class);
        Call<List<Pizza>> pizzaRespuestaCall = service.obtenerListaPiza();

        pizzaRespuestaCall.enqueue(new Callback<List<Pizza>>() {
            @Override
            public void onResponse(Call<List<Pizza>> call, Response<List<Pizza>> response) {

                if(response.isSuccessful()){
                    listaPizzaAdapter.adicionarPizza(response.body());
                }
                else{
                    Log.i("PIZZA", "onResponse: " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<Pizza>> call, Throwable t) {
                Log.i("PIZZA", "onFailure: " + t.getMessage());
            }
        });
    }
}