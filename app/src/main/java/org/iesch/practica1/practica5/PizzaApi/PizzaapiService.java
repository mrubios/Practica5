package org.iesch.practica1.practica5.PizzaApi;

import org.iesch.practica1.practica5.modelo.Pizza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PizzaapiService {
    @GET("pizzas")
    Call<List<Pizza>> obtenerListaPiza();
}
