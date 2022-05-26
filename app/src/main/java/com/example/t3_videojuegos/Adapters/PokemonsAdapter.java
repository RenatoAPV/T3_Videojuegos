package com.example.t3_videojuegos.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t3_videojuegos.Entities.Pokemon;
import com.example.t3_videojuegos.PokemonActivity;
import com.example.t3_videojuegos.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonsAdapter.PokemonViewHolder> {
    List<Pokemon> pokemons;
    public PokemonsAdapter(List<Pokemon> pokemons){
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item,parent,false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder vh, int position) {
        View itemView = vh.itemView;

        Pokemon pokemon = pokemons.get(position);
        TextView tvNombreA = vh.itemView.findViewById(R.id.tvNombrePokemon);
        TextView tvDescripA = vh.itemView.findViewById(R.id.tvCodigoPokemon);
        tvNombreA.setText(pokemon.name);
        tvDescripA.setText(pokemon.type);

        ImageView imagepokemon = vh.itemView.findViewById(R.id.ivPokemon);

        Picasso.get().load(pokemon.link).into(imagepokemon);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), PokemonActivity.class);

                String contactJSON = new Gson().toJson(pokemon);
                intent.putExtra("Pokemon", contactJSON);

                itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder{

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
