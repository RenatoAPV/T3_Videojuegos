package com.example.t3_videojuegos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.t3_videojuegos.Adapters.PokemonsAdapter;
import com.example.t3_videojuegos.Entities.Pokemon;
import com.example.t3_videojuegos.Factories.RetrofitFactory;
import com.example.t3_videojuegos.Services.PokemonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarPokemons extends AppCompatActivity {
    List<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_pokemons);

        Retrofit retrofit = RetrofitFactory.build();

        PokemonService service = retrofit.create(PokemonService.class);
        Call<List<Pokemon>> call = service.getPokemons();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if(response.isSuccessful()){
                    pokemons = response.body();

                    PokemonsAdapter adapter = new PokemonsAdapter(pokemons);

                    RecyclerView rv = findViewById(R.id.rvPokemons);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });
    }
}