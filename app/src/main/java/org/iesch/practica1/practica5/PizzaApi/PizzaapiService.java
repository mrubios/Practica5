package org.iesch.practica1.practica5.PizzaApi;

import org.iesch.practica1.practica5.modelo.PizzaRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PizzaapiService {
    @GET("/v2/pizzas")
    Call<PizzaRespuesta> obtenerListaPiza(@Query("limit") int limit, @Query("offset") int offset);
}
