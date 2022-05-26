package com.example.t3_videojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t3_videojuegos.Entities.Pokemon;
import com.example.t3_videojuegos.Factories.RetrofitFactory;
import com.example.t3_videojuegos.Services.PokemonService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_pokemon);

        String contactJson = getIntent().getStringExtra("Pokemon");
        Pokemon pokemon = new Gson().fromJson(contactJson, Pokemon.class);

        TextView tvName = findViewById(R.id.tvNombrePokemonD);
        TextView tvTipo = findViewById(R.id.tvTipPokemonD);
        TextView tvNumero = findViewById(R.id.tvNumeroPokemonD);
        TextView tvRegion = findViewById(R.id.tvRegionPokemonD);

        tvName.setText(pokemon.name);
        tvTipo.setText(pokemon.type);
        tvNumero.setText(pokemon.number);
        tvRegion.setText(pokemon.region);
        int id = pokemon.id;
        Button btnEliminar = findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = RetrofitFactory.build();
                PokemonService service = retrofit.create(PokemonService.class);

                Call<Pokemon> call = service.delete(pokemon.id);
            }
        });

    }
}