package com.example.t3_videojuegos.Services;

import com.example.t3_videojuegos.Entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PokemonService {
    @GET("pokemon")
    Call<List<Pokemon>> getPokemons();

    @DELETE("pokemon/{id}")
    Call<Pokemon> delete(@Path("id") int id);
}
